package lab2;

public class Checking extends Customer {
    /**
     * calling super class constructor.
     * @param lastName
     * @param firstName
     * @param id 
     */
    public Checking(String lastName, String firstName, long id) {
        super(lastName, firstName, id);
    }
    /**
     * calling super class constructor.
     * @param lastName
     * @param firstName 
     */
    public Checking(String lastName, String firstName) {
        super(lastName, firstName);
    }
    /**
     * calling super class constructor.
     * @param id 
     */
    public Checking(int id) {
        super(id);
    }
    /**
     * Gets the account info.
     * @return "checking".
     */
    @Override
    public String getAccountType() {
        return "Checking";
    }
}
