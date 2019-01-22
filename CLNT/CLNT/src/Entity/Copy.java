package Entity;

import java.io.Serializable;

public class Copy implements Serializable
{
  public String CopyID;
  public String locationShelf;
  public String status;
  public String bookID;
  public int orderBook;
  
  public Copy(String CopyID ,String locationShelf ,String status,String bookID,int orderBook) 
  {
	  this. CopyID= CopyID;
	  this.locationShelf=locationShelf;
	  this.status=status;
	  this.bookID=bookID;
	  this.orderBook=orderBook;
  }

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Copy [CopyID=" + CopyID + ", locationShelf=" + locationShelf + ", status=" + status + ", bookID=" + bookID
			+ ", orderBook=" + orderBook + "]";
}

/**
 * @return the copyID
 */
public String getCopyID() {
	return CopyID;
}

/**
 * @param copyID the copyID to set
 */
public void setCopyID(String copyID) {
	CopyID = copyID;
}

/**
 * @return the locationShelf
 */
public String getLocationShelf() {
	return locationShelf;
}

/**
 * @param locationShelf the locationShelf to set
 */
public void setLocationShelf(String locationShelf) {
	this.locationShelf = locationShelf;
}

/**
 * @return the status
 */
public String getStatus() {
	return status;
}

/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}

/**
 * @return the bookID
 */
public String getBookID() {
	return bookID;
}

/**
 * @param bookID the bookID to set
 */
public void setBookID(String bookID) {
	this.bookID = bookID;
}

/**
 * @return the orderBook
 */
public int getOrderBook() {
	return orderBook;
}

/**
 * @param orderBook the orderBook to set
 */
public void setOrderBook(int orderBook) {
	this.orderBook = orderBook;
}

}
