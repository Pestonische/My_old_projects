package JDBC;

import DAO.ServicemanDAO;
import DataSets.ServicemanData;
import org.h2.jdbcx.JdbcDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class DBService {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USER = "postgres";
    public static final String PASS = "password";

    private Connection connection = null;
    private final ServicemanDAO servicemanDAO;

    public DBService() throws SQLException {
        setupConnection();
        servicemanDAO = new ServicemanDAO(connection);
    }

    public ServicemanData getUser(long id) {
        return servicemanDAO.get(id);
    }

    public ArrayList<ServicemanData> getUsers(Predicate<ServicemanData> predicate) throws SQLException {
        return servicemanDAO.get(predicate);
    }

    public ArrayList<ServicemanData> getUsers() throws SQLException {
        return servicemanDAO.get(user -> true);
    }

    public void saveUser(ServicemanData servicemanData) throws SQLException {
        try {
            connection.setAutoCommit(false);
            servicemanDAO.createTable();
            servicemanDAO.save(servicemanData);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }

    }

    public void updateUser(ServicemanData servicemanData, String[] params) throws SQLException {
        try {
            connection.setAutoCommit(false);
            servicemanDAO.update(servicemanData, params);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }

    }

    public void deleteUserById(ServicemanData servicemanData) throws SQLException {
        try {
            connection.setAutoCommit(false);
            servicemanDAO.delete(servicemanData);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public void cleanUpUsers() throws SQLException {
        try {
            connection.setAutoCommit(false);
            servicemanDAO.dropTable();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
    }


    private void setupConnection() throws SQLException {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL(DB_URL);
        ds.setUser(USER);
        ds.setPassword(PASS);

        System.out.println("Connecting to database...");
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Database connection established");
    }

    public void createTable() throws SQLException {
        servicemanDAO.createTable();
    }


    public void dropTable() throws SQLException {
        servicemanDAO.dropTable();
    }

    public void clearTable() throws SQLException {
        servicemanDAO.createTable();
    }
}
