import java.util.Observer;

/**
 * 
 * Reminder 
 *
 */
public interface ReminderInterface {	
	
		 void addObserver(Observer observer);
		 void notifyAllObservers();
		  
	}

