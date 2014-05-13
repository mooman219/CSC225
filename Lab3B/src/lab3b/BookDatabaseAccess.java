package lab3b;

import java.sql.*;
import java.io.*;
import java.util.*;

/** BookDatabaseAccess class is a smorgasbord of techniques for accessing a database from 
 *  Java.  It's not a corucopia because myriad features are not demonstrated, but there 
 *  should be enough on the menu to whet your MCC GIS appetite.  Your system might be
 *  similar to this in that you may choose to utilize some of these techniques.
 *
 *  @author C Boettrich 
 */

public class BookDatabaseAccess 
{

   /** Extracts the entire contents of the database Books table
	 *  into a List object.  The order in which the fields in the
	 *  ResultSet are located is important. 
	 *  
	 *
	 *  @return a List of ABook objects
	 */
	public static List<ABook> LoadBookList()throws SQLException, IOException
	{
      List<ABook> bookList = new ArrayList<ABook>( );
		Connection conn = getConnection();
		Statement stat = conn.createStatement();	
		//Instance of the Java.sql package ResultSet class
		ResultSet result = stat.executeQuery("SELECT * FROM Books ORDER BY IDCode");
         
		while(result.next( ))
		{
         ABook bookBuffer = new ABook();             // create fresh ABook object
		   bookBuffer.setIDCode(result.getInt(1));     // first field in record from table
			bookBuffer.setAuthor(result.getString(2));  // second field in record from table
			bookBuffer.setTitle(result.getString(3));   // third field in record from table
			bookBuffer.setSubject(result.getString(4)); // fourth field in record from table
         bookList.add(bookBuffer);                   // add the book object to the List
      }

	   result.close();
		stat.close();
		conn.close();
		return bookList;
	}  	

   /** Demonstrates the insertion of a new book into the database's
	 *  Books table.  The method receives an ABook object and extracts
	 *  data values in a particular order to match the table structure.
	 *  
	 *
	 *  @param book an ABook object containing author, title, subject, etc
	 */
	public static int replaceBookTable(List<ABook> bookList)throws SQLException, IOException
   {
      // establish Connection with database and create Statement      
		Connection conn = getConnection();
      Statement stat = conn.createStatement();
		
		for(ABook book : bookList)
         stat.execute("INSERT INTO Books VALUES ('" + book.getIDCode() + "', '"
		                                              + book.getAuthor() + "', '" 
		                                              + book.getTitle() + "', '" 
		   												       + book.getSubject() + "')"); 
		   // select count(*) into result															  
		 stat.close();
       conn.close();
		 return 10;
   }
	
	
   /** Demonstrates the insertion of a new book into the database's
	 *  Books table.  The method receives an ABook object and extracts
	 *  data values in a particular order to match the table structure.
	 *  
	 *
	 *  @param book an ABook object containing author, title, subject, etc
	 */
	public static void insertNewBook(ABook book)throws SQLException, IOException
   {
      // establish Connection with database and create Statement      
		Connection conn = getConnection();
      Statement stat = conn.createStatement();
         
      stat.execute("INSERT INTO Books VALUES ('" + book.getIDCode() + "', '"
		                                         + book.getAuthor() + "', '" 
		                                         + book.getTitle() + "', '" 
		   												  + book.getSubject() + "')");  
		 stat.close();
       conn.close();
   }
	
   /** Demonstrates the update of a particular field in a 
	 *  particular record.  Receives an ABook object and 
	 *  updates the database table's subject field for 
	 *  a particular record based on the IDCode of the ABook.
	 *
	 *  @param book an ABook object containing author, title, subject, etc
	 */
   public static void updateBook(ABook book) throws SQLException, IOException
   {
      // establish Connection with database and create Statement object     
   	Connection conn = getConnection();
      Statement stat = conn.createStatement();
        
	   // highly specific functionality (for demonstration purposes)
      stat.execute("UPDATE Books SET Subject = '" + book.getSubject() + "' where IDCode = "
		                                            + book.getIDCode());
   
		stat.close();
      conn.close();
   }

   /** Demonstrates the deletion of particular book records based
	 *  on the IDCode being greater than or equal to some integer. 
	 *
	 *  @param number the lower "keep" threshold of IDCode
	 */
   public static void deleteBooks(int number) throws SQLException, IOException
   {
      // establish Connection with database and create Statement object     
   	Connection conn = getConnection();
      Statement stat = conn.createStatement();
        
	   // another highly specific functionality (for demonstration purposes)
      stat.execute("DELETE from Books where IDCode >= " + number);
   
		stat.close();
      conn.close();
   }

   /** Opens a database using the JDBC - ODBC driver
	 *  based on data stored in the dbprops.dat file 
	 *  stored in the local folder.  It is assumed that   
	 *  the ODBC administrator utility has been executed.
	 *
	 *  @return a Connection object
	 */
	 
   private static Connection getConnection()  throws SQLException, IOException
	{
      Properties props = new Properties();
      FileInputStream in = new FileInputStream("dbprops.dat");
      props.load(in);
      in.close();

      String drivers = props.getProperty("jdbc.drivers");

      if (drivers != null)
         System.setProperty("jdbc.drivers", drivers);

      String url = props.getProperty("jdbc.url");
      String username = props.getProperty("jdbc.username");
      String password = props.getProperty("jdbc.password");

      return DriverManager.getConnection(url, username, password);
   }
}