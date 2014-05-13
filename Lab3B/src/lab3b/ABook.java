package lab3b;

/** An ABook object corresponds to a record in the books table of
 *  the TheBooks.mdb database.
 *
 *
 */


class ABook{

   /** sequential code that is a key in the database table */
   private int idCode;  
	/** author of the book */
	private String author;
	/** title of the book */
   private String title;
	/** subject of the book */
   private String subject;
	
	/** default (no argument) constructor */
	public ABook()
	{
	}
	
	/** constructor to intialize the book
	  * @param id ID code
	  * @param au author
	  * @param ti title
	  * @param su subject
	  */  
	public ABook(int id, String au, String ti, String su)
	{
	   idCode = id;
      author = au;
      title = ti;
      subject = su;
	}
	
	/** access IDCode
	    @return the ID code */	 
	public int getIDCode(){
	   return idCode;
	}	
	
	/** access author
	    @return the book author */	 
	public String getAuthor(){
	   return author;
	}
			
	/** access title
	    @return the title */	 
	public String getTitle(){
	   return title;
	}

	/** access subject
	    @return the subject */	 
	public String getSubject(){
	   return subject;
	}

	/** set ID Code
	    @param id the IDCode */	 
	public void setIDCode(int id){
	   idCode = id;
	}	
	
	/** set author
	    @param a the author */	 
	public void setAuthor(String a){
	   author = a;
	}
			
	/** set title
	    @param t the title*/	 
	public void setTitle(String t){
	   title = t;
	}

	/** set the subject
	    @param s the subject */	 
	public void setSubject(String s){
	   subject = s;
	}

	/** get descriptice string
	    @return string containing onformation about the book*/	 
   public String toString()
	{
	   return author + ", " + title + ", " + subject;
	}	
}		
	   