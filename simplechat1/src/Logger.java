
public class Logger {
/**
 * 
 */
	public static boolean isDebug = true;
/**
 * 
 * @param debug
 */
	public Logger(boolean debug) {
		isDebug = debug;
	}
/**
 * 
 * @param message
 */
	public void log(String message) {
		System.out.println(message);
	}
/**
 * error
 * @param message
 */
	public void error(String message) {
		log("-ERROR: " + message);
	}
/**
 * 
 * @param message
 */
	public void info(String message) {
		log("" + message);
	}
/**
 *  warning
 * @param message
 */
	public void warning(String message) {
		log("Warn: " + message);
	}

	public void exception(Exception e) {
		error(e.getMessage());
		if (isDebug)
			e.printStackTrace();
	}
/**
 * debug
 * @param message
 */
	public void debug(String message) {
		if (!isDebug)
			return;

		log("-DEBUG: " + message);
	}
}
