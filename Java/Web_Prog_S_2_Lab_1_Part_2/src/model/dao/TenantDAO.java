package model.dao;

import model.entity.Tenant;
import model.exception.DAOException;
import model.exception.DBConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * tenant dao class
 *
 * @author Козунов Алексей
 * @version 1.0.0
 */
public class TenantDAO extends DAO {
	
	private static final String INSERT_REQUEST_SQL = "insert into request (type, numberWorkers, tenant_id, time) values(?, ?, ?, ?)";

    private static final String SELECT_ALL_Tenant_SQL = "select * from patients";

    private static final String SELECT_Tenant_BY_ID_SQL = "select * from patients where id = ?";
    
    
    /**
     * constructor
     *
     * @throws DAOException if Can't create connection
     */
    public TenantDAO() throws DAOException {
        super();
    }
	
    /**
     * read patient
     *
     * @return list of tenant
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Tenant> readTenant() throws DAOException {
    	ArrayList<Tenant> tenants = new ArrayList<Tenant>();
        Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_Tenant_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String FIO = rs.getString(2);
                Tenant tenant = new Tenant(id, FIO);
                tenants.add(tenant);
            }
            logger.info("read tenant");
        } catch (SQLException e) {
            throw new DAOException("Read tenant exception ", e);
        }catch (DBConnectionException e) {
            throw new DAOException("Faild to get connection from db connector ", e);
        } finally {
            if (connection != null) {
                try {
                    getDBConnector().releaseConnection(connection);
                } catch (DBConnectionException e) {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
        return tenants;
    }

    /**
     * read tenant by id
     *
     * @return tenant
     * @throws DAOException if Can't execute query or problems with connection
     */
    public Tenant readTenantById(int id) throws DAOException {
    	Tenant tenant = null;
        Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SELECT_Tenant_BY_ID_SQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String FIO = rs.getString(2);
                tenant = new Tenant(id, FIO);
            }
            logger.info("read tenant by id");
        } catch (SQLException e) {
            throw new DAOException("Read tenant exception ", e);
        }catch (DBConnectionException e) {
            throw new DAOException("Faild to get connection from db connector ", e);
        } finally {
            if (connection != null) {
                try {
                    getDBConnector().releaseConnection(connection);
                } catch (DBConnectionException e) {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
        return tenant;
    }

    /**
     * insert tenant
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void insertRequest(Tenant tenant, String type, int numberWorkers, int time) throws DAOException {
        Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(INSERT_REQUEST_SQL);
            stmt.setString(1, type);
            stmt.setInt(2, numberWorkers);
            stmt.setInt(3, tenant.getId());
            stmt.setInt(4, time);
            stmt.execute();
            logger.info("inserted request");
        } catch (SQLException e) {
            throw new DAOException("Insert request exception ", e);
        }catch (DBConnectionException e) {
            throw new DAOException("Faild to get connection from db connector ", e);
        } finally {
            if (connection != null) {
                try {
                    getDBConnector().releaseConnection(connection);
                } catch (DBConnectionException e) {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
    }
    
}
