package lab2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankTest {

    private Bank bank;

    public BankTest() {
        this.bank = new Bank();
    }

    /**
     * Reads each line in the file at 'path' and return the lines. This function
     * will return an empty list if the file does not exist.
     *
     * @param path - The location of the file.
     * @return A list of strings.
     */
    public static List<String> readFile(String path) {
        List<String> ret = new ArrayList<String>();
        File file = new File(path);
        if(file.exists()) {
            try(Scanner reader = new Scanner(file)) {
                while(reader.hasNextLine()) {
                    ret.add(reader.nextLine());
                }
            } catch(Exception e) {
                System.out.println("Error reading File.");
                e.printStackTrace();
            }
        }
        return ret;
    }

    public void parseFile(String path) {
        List<String> lines = readFile(path);
        for(String line : lines) {
            String[] args = line.split(" ");
            if(args[4].equalsIgnoreCase("savings")) {
                bank.add(new Savings(args[0], args[1], Long.parseLong(args[2]))).deposit(Double.parseDouble(args[3]));
            } else {
                bank.add(new Checking(args[0], args[1], Long.parseLong(args[2]))).deposit(Double.parseDouble(args[3]));
            }
        }
    }

    public void menu(String input) {
        String[] args = input.split(" ");
        Customer temp;
        switch(args[0]) {
            case "2": // Deposit
                temp = bank.get(new Checking(args[3], args[4]));
                if(temp != null) {
                    temp.deposit(Double.parseDouble(args[2]));
                } else {
                    System.out.println("Unable to find customer.");
                }
                break;
            case "3": // Withdraw
                temp = bank.get(new Checking(args[3], args[4]));
                if(temp != null) {
                    temp.withdraw(Double.parseDouble(args[2]));
                } else {
                    System.out.println("Unable to find customer.");
                }
                break;
            case "5": // Remove
                bank.remove(new Checking(args[2], args[3]));
                break;
            case "6": // Sort
                bank.sort();
                break;
            case "7": // Displays
                System.out.println(bank.toString());
                break;
            default:
                break;
        }
    }
}
