package Entity;

import java.io.Serializable;

public class itemInLoan implements Serializable
{
	public String StudentID;
	public String BookID;
	public String CopyID;
	public String loanDate;
	public String returnDate;
	
	public itemInLoan(String StudentID,String BookID,String CopyID,String loanDate,String returnDate)
	{
		this.StudentID=StudentID;
		this.BookID=BookID;
		this.CopyID=CopyID;
		this.loanDate=loanDate;
		this.returnDate=returnDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "itemInLoan [StudentID=" + StudentID + ", BookID=" + BookID + ", CopyID=" + CopyID + ", loanDate="
				+ loanDate + ", returnDate=" + returnDate + "]";
	}

	/**
	 * @return the studentID
	 */
	public String getStudentID() {
		return StudentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(String studentID) {
		StudentID = studentID;
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
	 * @return the loanDate
	 */
	public String getLoanDate() {
		return loanDate;
	}

	/**
	 * @param loanDate the loanDate to set
	 */
	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	/**
	 * @return the returnDate
	 */
	public String getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

}
