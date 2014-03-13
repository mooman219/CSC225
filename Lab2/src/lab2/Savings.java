package lab2;

public class Savings extends Customer {
    /**
     * Savings with all info.
     * @param lastName
     * @param firstName
     * @param id 
     */
    public Savings(String lastName, String firstName, long id) {
        super(lastName, firstName, id);
    }
    /**
     * Saving with last name and first name.
     * @param lastName
     * @param firstName 
     */
    public Savings(String lastName, String firstName) {
        super(lastName, firstName);
    }
    /**
     * Savings with id number.
     * @param id 
     */
    public Savings(int id) {
        super(id);
    }
    /**
     * Gets account info.
     * @return string
     */
    @Override
    public String getAccountType() {
        return "Savings";
    }
}
