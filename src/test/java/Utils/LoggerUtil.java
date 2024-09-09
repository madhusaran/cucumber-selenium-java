package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
	 private static Logger logger = LogManager.getLogger(LoggerUtil.class);
	 
	 public static Logger getLogger(){
		 return logger;
	 }
}
