package com.revature.logger;

import org.apache.log4j.Logger;

public class ProjectLogger {

	private final static Logger Log = Logger.getRootLogger();
	
	public static Logger getLog() {
		return Log;
	}
	
	public static void fatal(String message) {
		Log.fatal(message);
	}
	
	public static void error(String message) {
		Log.error(message);
	}
	
	public static void warn(String message) {
		Log.warn(message);
	}
	
	public static void debug(String message) {
		Log.debug(message);
	}
	public static void info(String message) {
		Log.info(message);
		
	}
	public static void trace(String message) {
		Log.trace(message);
	}
	
}
