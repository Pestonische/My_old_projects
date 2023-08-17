package model;

import model.exception.DBConnectionException;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DBConnectionPool
{
    private static final String DB_PROPERTIES = "database.properties";
    private static DBConnectionPool instance;
    private static Logger logger = LogManager.getLogManager().getLogger((DBConnectionPool.class).toString());
    private final int connectionCount = 4;
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private BlockingQueue<Connection> connections;

    private DBConnectionPool() throws DBConnectionException
    {
        if (instance != null)
        {
            return;
        }

        Properties properties = new Properties();
        try
        {
            properties.load(new FileInputStream(DB_PROPERTIES));
            logger.info("Properties file loaded");
        }
        catch (IOException e)
        {
            throw new DBConnectionException("properties file not loaded");
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");

        try
        {
            Class.forName(driver);
            logger.info("Driver loaded");
        }
        catch (ClassNotFoundException e)
        {
            throw new DBConnectionException("Error loading driver!", e);
        }

        connections = new ArrayBlockingQueue<>(connectionCount);
        try
        {
            for (int i = 0; i < connectionCount; i++)
            {
                Connection connection = DriverManager.getConnection(url, username, password);
                if (connection == null)
                {
                    throw new DBConnectionException("Wrong initial configuration");
                }
                connections.add(connection);
                logger.info("Successful connection #" + i);
            }
        }
        catch (SQLException e)
        {
            throw new DBConnectionException("Failed to connect", e);
        }
    }

    public static synchronized DBConnectionPool getInstance() throws DBConnectionException
    {
        if (instance == null)
        {
            instance = new DBConnectionPool();
        }
        return instance;
    }

    public synchronized void closeDBConnector() throws DBConnectionException
    {
        try
        {
            while (connections.size() > 0)
            {
                connections.take().close();
            }
        }
        catch (SQLException e)
        {
            throw new DBConnectionException("Could not close database connection ", e);
        }
        catch (InterruptedException e)
        {
            throw new DBConnectionException("Problem with concurrent queue", e);
        }
    }

    public synchronized Connection getConnection() throws DBConnectionException
    {
        try
        {
            return connections.take();
        }
        catch (InterruptedException e)
        {
            throw new DBConnectionException("Failed to get connection from pool", e);
        }
    }

    public synchronized void releaseConnection(Connection connection) throws DBConnectionException
    {
        try
        {
            if (connection.isClosed())
            {
                Connection newConnection = DriverManager.getConnection(url, username, password);
                connections.add(newConnection);
            }
            else
            {
                connections.add(connection);
            }
        }
        catch (SQLException e)
        {
            throw new DBConnectionException("Failed to establish connection", e);
        }

    }

}