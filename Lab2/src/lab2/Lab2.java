package lab2;

public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankTest bank = new BankTest();

        bank.parseFile("./bank.txt");

        //Sort the customers in ascending order based on the last and //first name
        System.out.println("sort the list");
        bank.menu("6");
        bank.menu("7");

        // print the customer list
        System.out.println("print the list");
        bank.menu("7");

        //Withdraw $125 from  Smith John account
        System.out.println("Withdraw $125 from Smith John account");

        bank.menu("3 : 125 Smith John");
        bank.menu("7");

        //Withdraw $300 from Smith John account
        System.out.println("Withdraw $300 from Smith John account");
        bank.menu("3 : 300 Smith John");
        bank.menu("7");

        //Deposit $500 to Clinton Hillery's account
        System.out.println("Deposit $500 to Clinton Hillery's account");
        bank.menu("2 : 500 Clinton Hillery");
        bank.menu("7");
        //Remove Obama Barak from the list
        System.out.println("Remove Obama Barak from the list");
        bank.menu("5 : Obama Barak");
        bank.menu("7");

        //Deposit -$100 into George Bush account
        System.out.println("Deposit - $100 into George Bush account");
        bank.menu("2 : -100 George Bush");

        //Withdraw -$50 from Biden Joe account
        System.out.println("Withdraw - $50 from Biden Joe account ");
        bank.menu("3 : -50 Biden Joe");
        bank.menu("7");
    }

}
