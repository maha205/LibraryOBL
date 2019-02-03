package application;

/**
 * 
 *Config
 *
 */
public class Config {
	public boolean isDebug= true;
	public String host = null;
	public int port = 0;
	
	private static Config instance = new Config();

	private Config() {
	}

	/**
	 * Get config
	 * @return
	 */
	public static Config getConfig() {
		return instance;
	}

	/**
	 * Getting port
	 * @return
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Setting port
	 * @param port
	 */
	public void setPort(int port) {
		this.port = port;
	}


	/**
	 * Getting host
	 * @return
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Setting host
	 * @param host
	 */
	public void setHost(String host) {
		this.host = host;
	}


}