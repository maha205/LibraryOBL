package TableView;

import javafx.beans.property.SimpleStringProperty;

public class Student {
	
	SimpleStringProperty ID;
	SimpleStringProperty Name;
	SimpleStringProperty Email;
	SimpleStringProperty Delay;
	
	public Student(String iD, String name, String email, String delay) {
		this.ID = new SimpleStringProperty(iD);
		this.Name = new SimpleStringProperty(name);
	    this.Email = new SimpleStringProperty(email);
	    this.Delay = new SimpleStringProperty(delay);
	}

	
	public String getID() {
		return this.ID.get();
	}


	public void setID(String iD) {
		this.ID.set(iD);
	}


	public String getName() {
		return this.Name.get();
	}


	public void setName(String name) {
		this.Name.set(name);
	}


	public String getDelay() {
		return this.Delay.get();
	}


	public void setDelay(String delay) {
		this.Delay.set(delay);
	}


	public String getEmail() {
		return this.Email.get();
	}


	public void setEmail(String email) {
		this.Email.set(email);
	}
}
