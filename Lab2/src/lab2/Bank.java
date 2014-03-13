package lab2;

public class Bank {

    private Customer[] customers = new Customer[30];
    private int customer_count = 0;
    
    /**
     * adds a new customer object and increases customer count,
     * sets customers equal to c.
     *
     * @param c - takes and object c in
     * @return Customer c.
     */
    public Customer add(Customer c) {
        ensureCapacity(++customer_count);
        customers[customer_count - 1] = c;
        return c;
    }
    /**
     * takes in customers, and can remove customers from the array.
     * 
     * 
     * @param c
     * @return removed
     */
    public boolean remove(Customer c) {
        boolean removed = false;
        int index = -1;
        while(!removed && index < customer_count) {
            index++;
            if(c.equals(customers[index])) {
                customers[index] = customers[--customer_count];
                customers[customer_count] = null;
                removed = true;
            }
        }
        return removed;
    }
    /**
     * gets customer info then sets it equal to result.
     * 
     * @param c
     * @return result 
     */
    public Customer get(Customer c) {
        Customer result = null;
        int index = -1;
        while(result == null && index < customer_count) {
            index++;
            if(c.equals(customers[index])) {
                result = customers[index];
            }
        }
        return result;
    }
    /**
     * finds a customer.
     * 
     * @param c
     * @return found
     */
    private int find(Customer c) {
        boolean found = false;
        int index = -1;
        while(!found && index < customer_count) {
            index++;
            if(c.equals(customers[index])) {
                found = true;
            }
        }
        return found ? index : -1;
    }
    /**
     * Sorts customers and compares customers to one another.
     */
    public void sort() {
        int n = customer_count;
        boolean sorted = false;  //turn to false if we make a swap
        while(!sorted) {
            sorted = true;
            for(int i = 0; i < n - 1; i++) {
                if(customers[i].compareTo(customers[i + 1]) > 0) {
                    Customer temp = customers[i + 1];
                    customers[i + 1] = customers[i];
                    customers[i] = temp;
                    sorted = false;
                }
            }
            n--; //go through 1 fewer elements each time, since end now sorted
        }
    }

    /**
     * Change the current capacity of this bag.
     * @param minimumCapacity the new capacity for this bag Data is instance
     * variable the array in this class
     * @postcondition This bag's capacity has been changed to at least
     * minimumCapacity. If the capacity was already at or greater than
     * minimumCapacity, then the capacity is left unchanged.
     * @exception OutOfMemoryError Indicates insufficient memory for: new
     * int[minimumCapacity].
     *
     */
    private void ensureCapacity(int minimumCapacity) {
        Customer biggerArray[];
        if(customers.length < minimumCapacity) {
            biggerArray = new Customer[minimumCapacity];
            System.arraycopy(customers, 0, biggerArray, 0, customer_count);
            customers = biggerArray;
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder(200);
        for(int i = 0; i < customer_count; i++) {
            ret.append(customers[i].getFirstName()).append(" ")
                    .append(customers[i].getLastName()).append(" ")
                    .append(customers[i].getId()).append(" ")
                    .append(customers[i].getBalance()).append(" ")
                    .append(customers[i].getAccountType()).append("\n");
        }
        return ret.toString();
    }
}
