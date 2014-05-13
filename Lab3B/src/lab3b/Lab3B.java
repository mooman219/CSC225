/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab3b;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ben
 */
public class Lab3B {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args)
   {
	   int numberOfBooks = 0;
      try
	   {
         List<ABook> bList;
	      BookDatabaseAccess theBookDB = new BookDatabaseAccess();

         // load the data into the list and print it out
		   bList = theBookDB.LoadBookList();
		   numberOfBooks = bList.size();

		   printTheList("Just loaded list", bList);
		
		   // add a new book
		   ABook newBook = new ABook();
		   newBook.setIDCode(++numberOfBooks); //new book, so increment first, then insert
		   newBook.setAuthor("Fowler, Martin");
		   newBook.setTitle("UML Distilled");
		   newBook.setSubject("Computer Fantasy");
		   theBookDB.insertNewBook(newBook);

         // reload the data into the list again and print it out		
		   bList = theBookDB.LoadBookList();
		   numberOfBooks = bList.size();
		   printTheList("Inserted new Record", bList);

		   int bookNum;
		   for (ABook a : bList) // If any book's subject is "Computer Fanasy",
		   {                     //  change the record to "Romance" 
		      if (a.getSubject().equals("Computer Fantasy"))
			   {
			      bookNum = a.getIDCode();
				   ABook updateBook = new ABook(bookNum, " ", " ", "Romance");
				   theBookDB.updateBook(updateBook);
		      }	
		   }
		   bList = theBookDB.LoadBookList();
		   numberOfBooks = bList.size();		
		   printTheList("Updated Category", bList);
			
			theBookDB.deleteBooks(23);
		   bList = theBookDB.LoadBookList();
		   numberOfBooks = bList.size();		
		   printTheList("Deleted Where IDCOde >= 23 ", bList);
	   }
	   catch (SQLException e)
	   {
	      System.out.println(e.getMessage());
	   }
	   catch (IOException e)
	   {
	      System.out.println(e.getMessage());
	   }	
		catch (Exception e)
		{
		   System.out.println(e.getMessage());
		}	
	}
	
   // Iterate through the list of books and print the ID, Author, Title, and Subject
   public static void printTheList(String message, List<ABook> theBookList)
	{		
	   System.out.println("-------------------------------------");
	   for (ABook a : theBookList)
		{
		   System.out.print(message);
		   System.out.println("  I, A, T, S: " + a.getIDCode() + " " 
				                + a.getAuthor() + " " + a.getTitle() 
					   			 + " " + a.getSubject());
		}
   }
}
