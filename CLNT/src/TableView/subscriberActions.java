package TableView;

import javafx.beans.property.SimpleStringProperty;

public class subscriberActions 
{
	SimpleStringProperty SubscriberID;
	SimpleStringProperty date;
	SimpleStringProperty Action;
	
	public subscriberActions(String SubscriberID, String date, String Action) {
		this.SubscriberID = new SimpleStringProperty(SubscriberID);
		this.date = new SimpleStringProperty(date);
	    this.Action= new SimpleStringProperty(Action);
	}

	/**
	 * @return the subscriberID
	 */
	public String getSubscriberID() {
		return this.SubscriberID.get();
	}

	/**
	 * @param subscriberID the subscriberID to set
	 */
	public void setSubscriberID(SimpleStringProperty subscriberID) {
		SubscriberID = subscriberID;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return this.date.get();
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(SimpleStringProperty date) {
		this.date = date;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return this.Action.get();
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(SimpleStringProperty action) {
		Action = action;
	}
}
