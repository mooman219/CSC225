package lab2;

import java.util.Objects;

public abstract class Customer implements Comparable<Customer> {

    private String lastName = "";
    private String firstName = "";
    private long id = 0;

    private double balance = 0;
    /**
     * Customer gets last name first name and id.
     * @param lastName
     * @param firstName
     * @param id 
     */
    public Customer(String lastName, String firstName, long id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }
    /**
     * Customer gets last name and first name.
     * @param lastName
     * @param firstName 
     */
    public Customer(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
    /**
     * Inputs customer id #.
     * @param id 
     */
    public Customer(int id) {
        this.id = id;
    }
    /**
     * customer method no input.
     */
    public Customer() {
    }
    /**
     * Outputs last name.
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     *  Sets the last name to lastName
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     *  Gets First Name
     * @return 
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     *  Sets first name to firstName.
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     *  Gets id number for customer.
     * @return id
     */
    public long getId() {
        return id;
    }
    /**
     * Set id number to id.
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Gets account balance
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
    /**
     *  Gets deposit amount and adds to bank account, then increases balance.
     * @param amount 
     */
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
    /**
     * Withdraws an amount then makes changes to balance, throws an insufficient funds error.
     * @param amount 
     */
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
    /**
     * Takes a customer and compares it using id.
     * @param object
     * @return id
     */
    @Override
    public int compareTo(Customer object) {
        return object.getId() == this.id ? 0 : object.getId() < this.id ? 1 : -1;
    }
    /**
     * To string method.
     * @return string
     */
    @Override
    public String toString() {
        return "Customer: " + this.getFirstName() + " " + this.getLastName() + ", " + this.getId() + "\n"
                + "Type of account: " + this.getAccountType() + "\n"
                + "Balance: " + this.getBalance() + "\n";
    }
    /**
     * equals method with an object, comparing customers and returning a boolean.
     * @param obj
     * @return boolean
     */
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
