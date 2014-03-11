package lab2;

import java.util.Objects;

public abstract class Customer implements Comparable<Customer> {

    private String lastName = "";
    private String firstName = "";
    private long id = 0;

    private double balance = 0;

    public Customer(String lastName, String firstName, long id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }

    public Customer(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount < 0) {
            System.out.println("--ERROR--\n"
                    + "Invalid deposit amount\n"
                    + toString()
                    + "Amount: " + amount + "\n");
        } else {
            this.balance += amount;
            System.out.println("Deposit completed\n"
                    + toString()
                    + "Amount: " + amount + "\n");
        }
    }

    public void withdraw(double amount) {
        if(amount < 0) {
            System.out.println("--ERROR--\n"
                    + "Invalid withdrawal amount\n"
                    + toString()
                    + "Amount Requested: " + amount + "\n");
        } else if(this.balance < amount) {
            System.out.println("--ERROR--\n"
                    + "Insufficient funds\n"
                    + toString()
                    + "Amount Requested: " + amount + "\n");
        } else {
            this.balance -= amount;
            System.out.println("Withdraw completed\n"
                    + toString()
                    + "Amount: " + amount + "\n");
        }
    }

    public abstract String getAccountType();

    @Override
    public int compareTo(Customer object) {
        return object.getId() == this.id ? 0 : object.getId() < this.id ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Customer: " + this.getFirstName() + " " + this.getLastName() + ", " + this.getId() + "\n"
                + "Type of account: " + this.getAccountType() + "\n"
                + "Balance: " + this.getBalance() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof Customer)) {
            return false;
        }
        final Customer other = (Customer) obj;
        if(!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if(!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        return true;
    }
}
