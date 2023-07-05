package info.esoft.test.api.logger;

import org.apache.log4j.LogManager;
import org.apache.logging.slf4j.Log4jLogger;

public class Logger {
    public static final org.apache.log4j.Logger LOG4J_LOGGER = LogManager.getLogger(Log4jLogger.class);
}
