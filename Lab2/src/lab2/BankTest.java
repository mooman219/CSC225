package lab2;

public class BankTest {

    private Bank bank;

    public BankTest() {
        this.bank = new Bank();
    }

    public void menu(String input) {
        String[] args = input.split(" ");
        switch(args[0]) {
            case "2": // Deposit
                bank.get(new Checking(args[3], args[4])).deposit(Double.parseDouble(args[2]));
                break;
            case "3": // Withdraw
                bank.get(new Checking(args[3], args[4])).withdraw(Double.parseDouble(args[2]));
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
