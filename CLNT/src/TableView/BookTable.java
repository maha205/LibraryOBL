package TableView;

import javafx.beans.property.SimpleStringProperty;

public class BookTable 
{
	SimpleStringProperty BookName;
	SimpleStringProperty BookID;
	SimpleStringProperty AuthorName;
	SimpleStringProperty Genre;
	SimpleStringProperty Description;
	SimpleStringProperty Shelf;
	SimpleStringProperty returnDate;
	
	public BookTable(String BookName, String BookID, String AuthorName, String Genre,String Description,String Shelf,String returnDate) {
		this.BookName=new SimpleStringProperty(BookName);
		this.BookID = new SimpleStringProperty(BookID);
	    this.AuthorName = new SimpleStringProperty(AuthorName);
	    this.Genre = new SimpleStringProperty(Genre);
	    this.Description = new SimpleStringProperty(Description);
	    this.Shelf = new SimpleStringProperty(Shelf);
	    this.returnDate = new SimpleStringProperty(returnDate);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookTable [BookName=" + BookName + ", BookID=" + BookID + ", AuthorName=" + AuthorName + ", Genre="
				+ Genre + ", Description=" + Description + ", Shelf=" + Shelf + ", returnDate=" + returnDate + "]";
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return BookName.get();
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(SimpleStringProperty bookName) {
		BookName = bookName;
	}

	/**
	 * @return the bookID
	 */
	public String getBookID() {
		return BookID.get();
	}

	/**
	 * @param bookID the bookID to set
	 */
	public void setBookID(SimpleStringProperty bookID) {
		BookID = bookID;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return AuthorName.get();
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(SimpleStringProperty authorName) {
		AuthorName = authorName;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return Genre.get();
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(SimpleStringProperty genre) {
		Genre = genre;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description.get();
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(SimpleStringProperty description) {
		Description = description;
	}

	/**
	 * @return the shelf
	 */
	public String getShelf() {
		return Shelf.get();
	}

	/**
	 * @param shelf the shelf to set
	 */
	public void setShelf(SimpleStringProperty shelf) {
		Shelf = shelf;
	}

	/**
	 * @return the returnDate
	 */
	public String getReturnDate() {
		return returnDate.get();
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(SimpleStringProperty returnDate) {
		this.returnDate = returnDate;
	}
}
