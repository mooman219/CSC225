package lab3b;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {

    /**
     * Constructor
     */
    public Database(String pfile) {

    }

    /**
     * Gets a connection from the properties specified in the file
     * database.properties
     *
     * @return the database connection
     */
    public Connection getConnection(String pfile) {
        return null;
        
    }

    /**
     * Create table
     */
    public void createTable(String tName, String fields) throws SQLException {

    }

    /**
     * insert data in the table
     */
    public void insertDataToTable(String tName, String fields, String line) throws Exception {

    }

    /**
     * Using Meta Data to display the information about each table, like the
     * coulmn name, column size, column type
     */
    public void showTablesInfo(String tableName) {

    }

    /**
     * display the records of the table
     */
    public void displayTableData(String tableName, ArrayList<String> fields) {

    }

    /**
     * Create a query
     */
    public void createQuery(String query, int numberOfFields) throws SQLException {

    }

    /**
     * Close the statement and the connection
     */
    public void close() throws SQLException, IOException {

    }

}
