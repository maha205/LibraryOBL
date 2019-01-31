package TableView;

import javafx.beans.property.SimpleStringProperty;

public class LendingReportRequestBook 
{
	SimpleStringProperty DuringRequestLending ;
	SimpleStringProperty noRequestSubscribers;
	
	public LendingReportRequestBook(String DuringRequestLending  ,String  noRequestSubscribers)
	{
		this.DuringRequestLending  = new SimpleStringProperty(DuringRequestLending );
		this.noRequestSubscribers=new SimpleStringProperty(noRequestSubscribers);
	}

	/**
	 * @return the duringRequestLending
	 */
	public String getDuringRequestLending() {
		return DuringRequestLending.get();
	}

	/**
	 * @param duringRequestLending the duringRequestLending to set
	 */
	public void setDuringRequestLending(SimpleStringProperty duringRequestLending) {
		DuringRequestLending = duringRequestLending;
	}

	/**
	 * @return the noRequestSubscribers
	 */
	public String getNoRequestSubscribers() {
		return noRequestSubscribers.get();
	}

	/**
	 * @param noRequestSubscribers the noRequestSubscribers to set
	 */
	public void setNoRequestSubscribers(SimpleStringProperty noRequestSubscribers) {
		this.noRequestSubscribers = noRequestSubscribers;
	}
}
