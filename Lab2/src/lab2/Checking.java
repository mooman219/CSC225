package lab2;

public class Checking extends Customer {

    public Checking(String lastName, String firstName, int id) {
        super(lastName, firstName, id);
    }

    public Checking(String lastName, String firstName) {
        super(lastName, firstName);
    }

    public Checking(int id) {
        super(id);
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }
}
