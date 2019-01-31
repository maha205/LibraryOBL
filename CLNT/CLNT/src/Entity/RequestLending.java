package Entity;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;

public class RequestLending implements Serializable
{
	String DuringRequestLending ;
	String noRequestSubscribers;
	
	public RequestLending(String duringRequestLending, String noRequestSubscribers) 
	{
		DuringRequestLending = duringRequestLending;
		this.noRequestSubscribers = noRequestSubscribers;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestLending [DuringRequestLending=" + DuringRequestLending + ", noRequestSubscribers="
				+ noRequestSubscribers + "]";
	}

	/**
	 * @return the duringRequestLending
	 */
	public String getDuringRequestLending() {
		return DuringRequestLending;
	}
	/**
	 * @param duringRequestLending the duringRequestLending to set
	 */
	public void setDuringRequestLending(String duringRequestLending) {
		DuringRequestLending = duringRequestLending;
	}
	/**
	 * @return the noRequestSubscribers
	 */
	public String getNoRequestSubscribers() {
		return noRequestSubscribers;
	}
	/**
	 * @param noRequestSubscribers the noRequestSubscribers to set
	 */
	public void setNoRequestSubscribers(String noRequestSubscribers) {
		this.noRequestSubscribers = noRequestSubscribers;
	}
}
