package lab2;

public class Checking extends Customer {

    public Checking(String lastName, String firstName, String id) {
        super(lastName, firstName, id);
    }

    public Checking(String lastName, String firstName) {
        super(lastName, firstName);
    }

    public Checking(String id) {
        super(id);
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }
}
