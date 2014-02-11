package lab2;

public class Savings extends Customer {

    public Savings(String lastName, String firstName, String id) {
        super(lastName, firstName, id);
    }

    public Savings(String lastName, String firstName) {
        super(lastName, firstName);
    }

    public Savings(String id) {
        super(id);
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}