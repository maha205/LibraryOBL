import java.util.Observer;

public interface ReminderInterface {	
	
		 void addObserver(Observer observer);
		 void notifyAllObservers();
		  
	}

