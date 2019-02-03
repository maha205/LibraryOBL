package application;

import javafx.beans.property.SimpleStringProperty;
/**
 * 
 * Orders for table 
 *
 */
public class OrdersForTable {
	SimpleStringProperty StudentID;
	SimpleStringProperty BookID;
	SimpleStringProperty OrderDate;
	SimpleStringProperty ExpiredDay;
	SimpleStringProperty OrderID;
	public OrdersForTable(String studentID, String bookID, String orderDate, String expiredDay, String orderID) {
		StudentID = new SimpleStringProperty(studentID);
		BookID = new SimpleStringProperty(bookID);
		OrderDate = new SimpleStringProperty(orderDate);
		ExpiredDay = new SimpleStringProperty(expiredDay);
		OrderID = new SimpleStringProperty(orderID);
	}
	/**
	 * Getting StudentID
	 * @return StudentID
	 */
	public String getStudentID() {
		return this.StudentID.get();
	}
	/**
	 * Setting StudentID
	 * @param studentID
	 */
	public void setStudentID(String studentID) {
		this.StudentID.set(studentID);
	}
	/**
	 * Getting BookID
	 * @return
	 */
	public String getBookID() {
		return this.BookID.get();
	}
	/**
	 * Setting StudentID
	 * @param bookID
	 */
	public void setBookID(String bookID) {
		this.BookID.set(bookID);
	}
	/**
	 * Getting OrderDate
	 * @return OrderDate
	 */
	public String getOrderDate() {
		return this.OrderDate.get();
	}

	/**
	 * Setting OrderDate
	 * @param orderDate
	 */
	public void setOrderDate(String orderDate) {
		this.OrderDate.set(orderDate);
	}
	/**
	 * Getting ExpiredDay 
	 * @return ExpiredDay
	 */
	public String getExpiredDay() {
		return this.ExpiredDay.get();
	}
	/**
	 * Setting ExpiredDay
	 * @param expiredDay
	 */
	public void setExpiredDay(String expiredDay) {
		this.ExpiredDay.set(expiredDay);
	}
	/**
	 * Getting OrderID
	 * @return OrderID
	 */
	public String getOrderID() {
		return this.OrderID.get();
	}
	/**
	 * Setting OrderID
	 * @param orderID
	 */	
	public void setOrderID(String orderID) {
		this.OrderID.set(orderID);
	}
}
