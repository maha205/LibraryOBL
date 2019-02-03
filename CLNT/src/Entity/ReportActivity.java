package Entity;

import java.io.Serializable;

public class ReportActivity implements Serializable
{
	String activeSubscribers ;
	String frozenSubscribers;
	String lockedSubscribers;
	String copiesNumber;
	String delayReurning;
	String reportDate;
	
	public ReportActivity (String activeSubscribers,String frozenSubscribers, String lockedSubscribers, String copiesNumber,String delayReurning,String reportDate) {
		this.activeSubscribers =activeSubscribers;
		this.frozenSubscribers=frozenSubscribers;
		this.lockedSubscribers= lockedSubscribers;
	    this.copiesNumber = copiesNumber;
	    this.delayReurning =delayReurning;
	    this.reportDate= reportDate;
	}

	/**
	 * @return the activeSubscribers
	 */
	public String getActiveSubscribers() {
		return activeSubscribers;
	}

	/**
	 * @param activeSubscribers the activeSubscribers to set
	 */
	public void setActiveSubscribers(String activeSubscribers) {
		this.activeSubscribers = activeSubscribers;
	}

	/**
	 * @return the frozenSubscribers
	 */
	public String getFrozenSubscribers() {
		return frozenSubscribers;
	}

	/**
	 * @param frozenSubscribers the frozenSubscribers to set
	 */
	public void setFrozenSubscribers(String frozenSubscribers) {
		this.frozenSubscribers = frozenSubscribers;
	}

	/**
	 * @return the lockedSubscribers
	 */
	public String getLockedSubscribers() {
		return lockedSubscribers;
	}

	/**
	 * @param lockedSubscribers the lockedSubscribers to set
	 */
	public void setLockedSubscribers(String lockedSubscribers) {
		this.lockedSubscribers = lockedSubscribers;
	}

	/**
	 * @return the copiesNumber
	 */
	public String getCopiesNumber() {
		return copiesNumber;
	}

	/**
	 * @param copiesNumber the copiesNumber to set
	 */
	public void setCopiesNumber(String copiesNumber) {
		this.copiesNumber = copiesNumber;
	}

	/**
	 * @return the delayReurning
	 */
	public String getDelayReurning() {
		return delayReurning;
	}

	/**
	 * @param delayReurning the delayReurning to set
	 */
	public void setDelayReurning(String delayReurning) {
		this.delayReurning = delayReurning;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReportActivity [activeSubscribers=" + activeSubscribers + ", frozenSubscribers=" + frozenSubscribers
				+ ", lockedSubscribers=" + lockedSubscribers + ", copiesNumber=" + copiesNumber + ", delayReurning="
				+ delayReurning + ", reportDate=" + reportDate + "]";
	}

	public String getReportDate() {
		// TODO Auto-generated method stub
		return  this.reportDate;
	}

	
	
}
