package TableView;

import javafx.beans.property.SimpleStringProperty;

public class LendingReportNormalBook 
{
	SimpleStringProperty DuringNormalLending ;
	SimpleStringProperty noNormalSubscribers;
	
	public LendingReportNormalBook(String DuringNormalLending ,String  noNormalSubscribers)
	{
		this.DuringNormalLending = new SimpleStringProperty(DuringNormalLending);
		this.noNormalSubscribers=new SimpleStringProperty(noNormalSubscribers);
	}

	/**
	 * @return the duringNormalLending
	 */
	public String getDuringNormalLending() {
		return DuringNormalLending.get();
	}

	/**
	 * @param duringNormalLending the duringNormalLending to set
	 */
	public void setDuringNormalLending(SimpleStringProperty duringNormalLending) {
		DuringNormalLending = duringNormalLending;
	}

	/**
	 * @return the noNormalSubscribers
	 */
	public String getNoNormalSubscribers() {
		return noNormalSubscribers.get();
	}

	/**
	 * @param noNormalSubscribers the noNormalSubscribers to set
	 */
	public void setNoNormalSubscribers(SimpleStringProperty noNormalSubscribers) {
		this.noNormalSubscribers = noNormalSubscribers;
	}

}
