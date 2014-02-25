package lab2;

public class Bank {

    private Customer[] customers = new Customer[30];
    private int customer_count = 0;

    public void add(Customer c) {
        ensureCapacity(customer_count++);
        customers[customer_count - 1] = c;
    }

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
}
