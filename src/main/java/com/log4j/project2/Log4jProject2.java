package com.log4j.project2;

import org.apache.log4j.Logger;

public class Log4jProject2 {

	private static Logger Log = Logger.getRootLogger();
	
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
