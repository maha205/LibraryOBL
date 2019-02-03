package TableView;

import javafx.beans.property.SimpleStringProperty;

/**
 * 
 *Student
 *
 */
public class Student {
	
	SimpleStringProperty ID;
	SimpleStringProperty Name;
	SimpleStringProperty Email;
	SimpleStringProperty Delay;
	/**
	 * 
	 * @param iD
	 * @param name
	 * @param email
	 * @param delay
	 */
	public Student(String iD, String name, String email, String delay) {
		this.ID = new SimpleStringProperty(iD);
		this.Name = new SimpleStringProperty(name);
	    this.Email = new SimpleStringProperty(email);
	    this.Delay = new SimpleStringProperty(delay);
	}

	/**
	 * Getting ID
	 * @return
	 */
	public String getID() {
		return this.ID.get();
	}


	/**
	 * Setting ID
	 * @param iD
	 */
	public void setID(String iD) {
		this.ID.set(iD);
	}


	/**
	 * Getting Name
	 * @return
	 */
	public String getName() {
		return this.Name.get();
	}


	/**
	 * Setting Name
	 * @param name
	 */
	public void setName(String name) {
		this.Name.set(name);
	}


	/**
	 * Getting Delay
	 * @return
	 */
	public String getDelay() {
		return this.Delay.get();
	}


	/**
	 * Setting Delay
	 * @param delay
	 */
	public void setDelay(String delay) {
		this.Delay.set(delay);
	}


	/**
	 * Getting Email
	 * @return
	 */
	public String getEmail() {
		return this.Email.get();
	}


	/**
	 * Setting Email
	 * @param email
	 */
	public void setEmail(String email) {
		this.Email.set(email);
	}
}
