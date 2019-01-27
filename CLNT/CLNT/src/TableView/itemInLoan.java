package TableView;

import javafx.beans.property.SimpleStringProperty;

public class itemInLoan {
	SimpleStringProperty StudentID ;
	SimpleStringProperty BookName;
	SimpleStringProperty BookID;
	SimpleStringProperty CopyID;
	SimpleStringProperty loanDate;
	SimpleStringProperty returnDate;
	
	
	public itemInLoan(String StudentID,String BookName, String BookID, String CopyID, String loanDate,String returnDate) {
		this.StudentID = new SimpleStringProperty(StudentID);
		this.BookName=new SimpleStringProperty(BookName);
		this.BookID = new SimpleStringProperty(BookID);
	    this.CopyID = new SimpleStringProperty(CopyID);
	    this.loanDate = new SimpleStringProperty(loanDate);
	    this.returnDate = new SimpleStringProperty(returnDate);
	}
	
	public String getBookName() {
		return this.BookName.get();
	}

	
	public void setBookName(SimpleStringProperty BookName) {
		BookName = BookName;
	}
	
	/**
	 * @return the studentID
	 */
	public String getStudentID() {
		return this.StudentID.get();
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(SimpleStringProperty studentID) {
		StudentID = studentID;
	}

	/**
	 * @return the bookID
	 */
	public String getBookID() {
		return this.BookID.get();
	}

	/**
	 * @param bookID the bookID to set
	 */
	public void setBookID(SimpleStringProperty bookID) {
		BookID = bookID;
	}

	/**
	 * @return the copyID
	 */
	public String getCopyID() {
		return this.CopyID.get();
	}

	/**
	 * @param copyID the copyID to set
	 */
	public void setCopyID(SimpleStringProperty copyID) {
		CopyID = copyID;
	}

	/**
	 * @return the loanDate
	 */
	public String getLoanDate() {
		return this.loanDate.get();
	}

	/**
	 * @param loanDate the loanDate to set
	 */
	public void setLoanDate(SimpleStringProperty loanDate) {
		this.loanDate = loanDate;
	}

	/**
	 * @return the returnDate
	 */
	public String getReturnDate() {
		return this.returnDate.get();
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(SimpleStringProperty returnDate) {
		this.returnDate = returnDate;
	}

}
