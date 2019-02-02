package application;

import javafx.beans.property.SimpleStringProperty;

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
	public String getStudentID() {
		return this.StudentID.get();
	}
	public void setStudentID(String studentID) {
		this.StudentID.set(studentID);
	}
	public String getBookID() {
		return this.BookID.get();
	}
	public void setBookID(String bookID) {
		this.BookID.set(bookID);
	}
	public String getOrderDate() {
		return this.OrderDate.get();
	}
	public void setOrderDate(String orderDate) {
		this.OrderDate.set(orderDate);
	}
	public String getExpiredDay() {
		return this.ExpiredDay.get();
	}
	public void setExpiredDay(String expiredDay) {
		this.ExpiredDay.set(expiredDay);
	}
	public String getOrderID() {
		return this.OrderID.get();
	}
	public void setOrderID(String orderID) {
		this.OrderID.set(orderID);
	}
}
