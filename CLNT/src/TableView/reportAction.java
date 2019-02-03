package TableView;

import javafx.beans.property.SimpleStringProperty;

public class reportAction 
{
	SimpleStringProperty activeSubscribers ;
	SimpleStringProperty frozenSubscribers;
	SimpleStringProperty lockedSubscribers;
	SimpleStringProperty copiesNumber;
	SimpleStringProperty delayReurning;
	SimpleStringProperty reportDate;
	
	
	public reportAction(String activeSubscribers,String frozenSubscribers, String lockedSubscribers, String copiesNumber,String delayReurning,String reportDate) {
		this.activeSubscribers = new SimpleStringProperty(activeSubscribers);
		this.frozenSubscribers=new SimpleStringProperty(frozenSubscribers);
		this.lockedSubscribers= new SimpleStringProperty(lockedSubscribers);
	    this.copiesNumber = new SimpleStringProperty(copiesNumber);
	    this.delayReurning = new SimpleStringProperty(delayReurning);
	    this. reportDate = new SimpleStringProperty( reportDate);
	}

	public String getReportDate() {
		return reportDate.get();
	}

	/**
	 * @param activeSubscribers the activeSubscribers to set
	 */
	public void setReportDate(SimpleStringProperty reportDate) {
		this.reportDate = reportDate;
	}
	/**
	 * @return the activeSubscribers
	 */
	public String getActiveSubscribers() {
		return activeSubscribers.get();
	}

	/**
	 * @param activeSubscribers the activeSubscribers to set
	 */
	public void setActiveSubscribers(SimpleStringProperty activeSubscribers) {
		this.activeSubscribers = activeSubscribers;
	}

	/**
	 * @return the frozenSubscribers
	 */
	public String getFrozenSubscribers() {
		return frozenSubscribers.get();
	}

	/**
	 * @param frozenSubscribers the frozenSubscribers to set
	 */
	public void setFrozenSubscribers(SimpleStringProperty frozenSubscribers) {
		this.frozenSubscribers = frozenSubscribers;
	}

	/**
	 * @return the lockedSubscribers
	 */
	public String getLockedSubscribers() {
		return lockedSubscribers.get();
	}

	/**
	 * @param lockedSubscribers the lockedSubscribers to set
	 */
	public void setLockedSubscribers(SimpleStringProperty lockedSubscribers) {
		this.lockedSubscribers = lockedSubscribers;
	}

	/**
	 * @return the copiesNumber
	 */
	public String getCopiesNumber() {
		return copiesNumber.get();
	}

	/**
	 * @param copiesNumber the copiesNumber to set
	 */
	public void setCopiesNumber(SimpleStringProperty copiesNumber) {
		this.copiesNumber = copiesNumber;
	}

	/**
	 * @return the delayReurning
	 */
	public String getDelayReurning() {
		return delayReurning.get();
	}

	/**
	 * @param delayReurning the delayReurning to set
	 */
	public void setDelayReurning(SimpleStringProperty delayReurning) {
		this.delayReurning = delayReurning;
	}
	
	
}
