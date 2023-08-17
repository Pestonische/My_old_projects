package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;


import model.exception.DBConnectionException;

/**
 * database connector singleton class
 *
 * @author Козунов Алексей
 * @version 1.0.0
 */
public class JdbcConnector {
	
	private static Logger logger = Logger.getLogger("database_layer");
	private static final String DB_PROPERTIES = "database/database.properties";
	private static JdbcConnector instance;
	private static String driver;
    private static String DB_URL;
    private static String user;
    private static String password;
	private Connection connect;
	
    public JdbcConnector() throws DBConnectionException {
    	if (instance != null) {
            return;
        }
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(DB_PROPERTIES));
            //logger.info("Properties file loaded");
        } catch (IOException e) {
            //throw new DBConnectionException("properties file not loaded");
        }
        driver = properties.getProperty("driver");
        DB_URL = properties.getProperty("host");
        user = properties.getProperty("login");
        password = properties.getProperty("password");

        try {
            Class.forName(driver);
            logger.info("Driver loaded");
        } catch (ClassNotFoundException e) {
            throw new DBConnectionException("Error loading driver!", e);
        }
        try {
        	connect = DriverManager.getConnection(DB_URL, user, password); 
	        if (connect == null) {
	            throw new DBConnectionException("Driver type is not correct in URL " + DB_URL + ".");
	        }
        } catch (SQLException e) {
             throw new DBConnectionException("Failed to establish connection", e);
        }
	}
    
    /**
     * return instance JDBConnector or create it
     *
     * @return instance of Singleton
     */
    public static JdbcConnector getInstance() throws DBConnectionException {
        if (instance == null) {
            instance = new JdbcConnector();
        }
        return instance;
    }
    
    public Connection getConnection() {
		return connect;
    }
    
    /**
     * deinit database of connections
     *
     * @throws DBConnectionException if properties file loading error
     */
    public void deinitDBConnector() throws DBConnectionException {
        try {
        	connect.close();
        } catch (SQLException e) {
            throw new DBConnectionException("Could not close database connection ", e);
        }
        //logger.info("DB pool of connections deinited");
    }
    
}
