package Entity;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;

public class NormalLending implements Serializable
{
	String DuringNormalLending ;
	String noNormalSubscribers;
	
	public NormalLending(String duringNormalLending, String noNormalSubscribers)
	{
		DuringNormalLending = duringNormalLending;
		this.noNormalSubscribers = noNormalSubscribers;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NormalLending [DuringNormalLending=" + DuringNormalLending + ", noNormalSubscribers="
				+ noNormalSubscribers + "]";
	}

	/**
	 * @return the duringNormalLending
	 */
	public String getDuringNormalLending() {
		return DuringNormalLending;
	}
	/**
	 * @param duringNormalLending the duringNormalLending to set
	 */
	public void setDuringNormalLending(String duringNormalLending) {
		DuringNormalLending = duringNormalLending;
	}
	/**
	 * @return the noNormalSubscribers
	 */
	public String getNoNormalSubscribers() {
		return noNormalSubscribers;
	}
	/**
	 * @param noNormalSubscribers the noNormalSubscribers to set
	 */
	public void setNoNormalSubscribers(String noNormalSubscribers) {
		this.noNormalSubscribers = noNormalSubscribers;
	}
}
