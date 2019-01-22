package Entity;

import java.io.Serializable;

public class Book implements Serializable 
{
  public String BookID ;
  public String BookName ;
  public String Author ;
  public String genre ;
  public String description;
  public String publisher;
  public String printdate;
  public int copyQuantity;
  public int OrderQantity;
  
	public Book(String BookID ,String BookName,String Author ,String genre ,String description,String publisher,String printdate,int copyQuantity,int OrderQantity) 
	{
		this.BookID = BookID;
		this.BookName = BookName ;
		this.Author=Author;
		this.genre =genre;
		this.description=description;
		this.publisher=publisher;
		this.printdate=printdate;
		this.copyQuantity=copyQuantity;
		this.OrderQantity=OrderQantity;
	}
	/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Book [BookID=" + BookID + ", BookName=" + BookName + ", Author=" + Author + ", genre=" + genre
			+ ", description=" + description + ", publisher=" + publisher + ", printdate=" + printdate
			+ ", copyQuantity=" + copyQuantity + ", OrderQantity=" + OrderQantity + ", getBookID()=" + getBookID()
			+ ", getBookName()=" + getBookName() + ", getAuthor()=" + getAuthor() + ", getGenre()=" + getGenre()
			+ ", getDescription()=" + getDescription() + ", getPublisher()=" + getPublisher() + ", getPrintdate()="
			+ getPrintdate() + ", getCopyQuantity()=" + getCopyQuantity() + ", getOrderQantity()=" + getOrderQantity()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}

	/**
 * @return the bookID
 */
public String getBookID() {
	return BookID;
}

/**
 * @param bookID the bookID to set
 */
public void setBookID(String bookID) {
	BookID = bookID;
}

/**
 * @return the bookName
 */
public String getBookName() {
	return BookName;
}

/**
 * @param bookName the bookName to set
 */
public void setBookName(String bookName) {
	BookName = bookName;
}

/**
 * @return the author
 */
public String getAuthor() {
	return Author;
}

/**
 * @param author the author to set
 */
public void setAuthor(String author) {
	Author = author;
}

/**
 * @return the genre
 */
public String getGenre() {
	return genre;
}

/**
 * @param genre the genre to set
 */
public void setGenre(String genre) {
	this.genre = genre;
}

/**
 * @return the description
 */
public String getDescription() {
	return description;
}

/**
 * @param description the description to set
 */
public void setDescription(String description) {
	this.description = description;
}

/**
 * @return the publisher
 */
public String getPublisher() {
	return publisher;
}

/**
 * @param publisher the publisher to set
 */
public void setPublisher(String publisher) {
	this.publisher = publisher;
}

/**
 * @return the printdate
 */
public String getPrintdate() {
	return printdate;
}

/**
 * @param printdate the printdate to set
 */
public void setPrintdate(String printdate) {
	this.printdate = printdate;
}

/**
 * @return the copyQuantity
 */
public int getCopyQuantity() {
	return copyQuantity;
}

/**
 * @param copyQuantity the copyQuantity to set
 */
public void setCopyQuantity(int copyQuantity) {
	this.copyQuantity = copyQuantity;
}

/**
 * @return the orderQantity
 */
public int getOrderQantity() {
	return OrderQantity;
}

/**
 * @param orderQantity the orderQantity to set
 */
public void setOrderQantity(int orderQantity) {
	OrderQantity = orderQantity;
}
}
