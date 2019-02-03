package TableView;

import javafx.beans.property.SimpleStringProperty;

/**
 * 
 * Order for tables 
 *
 */
public class OrdersForTable {
	SimpleStringProperty StudentID;
	SimpleStringProperty BookID;
	SimpleStringProperty OrderDate;
	SimpleStringProperty ExpiredDay;
	SimpleStringProperty OrderID;
	
	/**
	 * 
	 * @param studentID
	 * @param bookID
	 * @param orderDate
	 * @param expiredDay
	 * @param orderID
	 */
	public OrdersForTable(String studentID, String bookID, String orderDate, String expiredDay, String orderID) {
		StudentID = new SimpleStringProperty(studentID);
		BookID = new SimpleStringProperty(bookID);
		OrderDate = new SimpleStringProperty(orderDate);
		ExpiredDay = new SimpleStringProperty(expiredDay);
		OrderID = new SimpleStringProperty(orderID);
	}
	/**
	 * Getting StudentID
	 * @return
	 */
	public String getStudentID() {
		return this.StudentID.get();
	}
	/**
	 *  Setting StudentID
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
	 * Setting BookID
	 * @param bookID
	 */
	public void setBookID(String bookID) {
		this.BookID.set(bookID);
	}
	/**
	 * Getting OrderDate
	 * @return
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
	 * @return
	 */
	public String getExpiredDay() {
		return this.ExpiredDay.get();
	}
	/**
	 * setting ExpiredDay
	 * @param expiredDay
	 */
	public void setExpiredDay(String expiredDay) {
		this.ExpiredDay.set(expiredDay);
	}
	/**
	 * Getting OrderID
	 * @return
	 */
	public String getOrderID() {
		return this.OrderID.get();
	}
	/**
	 * setting OrderID
	 * @param orderID
	 */
	public void setOrderID(String orderID) {
		this.OrderID.set(orderID);
	}
}
