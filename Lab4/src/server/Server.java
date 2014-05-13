package server;

import packet.Packet;
import packet.Packet2Text;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {

    public static Window gui;
    public static ServerSocket serverSocket;
    public static CopyOnWriteArrayList<Connection> connections = new CopyOnWriteArrayList<Connection>();

    public static void main(String args[]) {
        gui = new Window();
        gui.setVisible(true);
        try {
            serverSocket = new ServerSocket(12081, 10);
            AcceptThread acceptThread = new AcceptThread();
            acceptThread.start();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Calculate method, takes in input from gui and does calculation, then
     * sends output back to gui
     */
    public static String calculate(String str) {
        RationalNumber a, b;
        String[] breakdown = str.split(" ");
        StringBuilder ret = new StringBuilder(str);
        ret.append(" = ");

        try {
            a = new RationalNumber(breakdown[0]);
            b = new RationalNumber(breakdown[2]);
        } catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
            return "Invalid number format.";
        }

        switch(breakdown[1]) {
            case "+":
                ret.append(a.add(b).toString());
                break;
            case "-":
                ret.append(a.sub(b).toString());
                break;
            case "*":
                ret.append(a.mlt(b).toString());
                break;
            case "/":
                ret.append(a.div(b).toString());
                break;
            case "<":
                ret.append(a.lt(b));
                break;
            case ">":
                ret.append(a.gt(b));
                break;
            case "=":
            case "==":
                ret.append(a.eq(b));
                break;
            case "<=":
                ret.append(a.le(b));
                break;
            case ">=":
                ret.append(a.ge(b));
                break;
            default:
                return "Invalid operator.";
        }

        return ret.toString();
    }

    public static class AcceptThread extends Thread {

        public void run() {
            while(true) {
                try {
                    Socket connection = serverSocket.accept();
                    gui.addText("Connection received from " + connection.getInetAddress().getHostName());
                    connections.add(new Connection(connection));
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static class Connection {

        private final Socket connection;
        private final ReceiveThread reciveThread;

        private ObjectOutputStream out;
        private ObjectInputStream in;

        public Connection(Socket connection) {
            this.connection = connection;
            this.reciveThread = new ReceiveThread(this);
            try {
                this.out = new ObjectOutputStream(connection.getOutputStream());
                this.in = new ObjectInputStream(connection.getInputStream());
                this.out.flush();
                this.reciveThread.start();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }

        public void sendText(String text) {
            Packet2Text test = new Packet2Text();
            test.text = text;
            Packet.send(out, test);
        }

        public static class ReceiveThread extends Thread {

            private final Connection connection;

            public ReceiveThread(Connection connection) {
                this.connection = connection;
            }

            public void run() {
                while(true) {
                    try {
                        Packet packet = Packet.next(connection.in);
                        if(packet != null) {
                            switch(packet.getId()) {
                                case 0:
                                    break;
                                case 1:
                                    break;
                                case 2:
                                    gui.addText("Got: " + ((Packet2Text) packet).text);
                                    gui.addText("Solved: " + calculate(((Packet2Text) packet).text));
                                    connection.sendText(calculate(((Packet2Text) packet).text));
                                    break;
                            }
                        }
                    } catch(IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
