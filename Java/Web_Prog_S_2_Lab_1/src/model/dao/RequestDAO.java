package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.Request;
import model.entity.Tenant;
import model.exception.DAOException;

/**
 * request dao class
 *
 * @author Козунов Алексей
 * @version 1.0.0
 */
public class RequestDAO extends DAO {

    private static final String DELETE_REQUEST_SQL = "delete from request where id = ?";

    private static final String SELECT_ALL_REQUEST_SQL = "select * from request";

    private static final String SELECT_REQUEST_BY_OVERDUE_SQL = "select * from request where overdue = ?";

    private static final String SELECT_REQUEST_BY_ID_SQL = "select * from request where id = ?";

    private static final String UPDATE_REQUEST_COMPLETE_SQL = "update request set complete = ? where id = ?";

    private static final String UPDATE_REQUEST_OVERDUE_SQL = "update request set overdue = ? where id = ?";

    /**
     * constructor
     *
     * @throws DAOException if Can't create connection
     */
    public RequestDAO() throws DAOException {
        super();
    }

    /**
     * read request
     *
     * @return list of request
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Request> readRequest() throws DAOException {
        ArrayList<Request> requests = new ArrayList<Request>();
        Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_REQUEST_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String type = rs.getString(2);
                int numberWorkers = rs.getInt(3);
                int tenant_id = rs.getInt(4);
                int time = rs.getInt(5);
                boolean overdue = rs.getBoolean(6);
                boolean complete = rs.getBoolean(7);
                Request request = new Request(id, type, numberWorkers, tenant_id, time, overdue, complete);
                requests.add(request);
            }
            logger.info("read request");
        } catch (SQLException e) {
            throw new DAOException("Read request exception ", e);
        } 
        return requests;
    }

    /**
     * read request by id
     *
     * @return request
     * @throws DAOException if Can't execute query or problems with connection
     */
    public Request selectRequestById(int idTask) throws DAOException {
        Request request = null;
        Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SELECT_REQUEST_BY_ID_SQL);
            stmt.setInt(1, idTask);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String type = rs.getString(2);
                int numberWorkers = rs.getInt(3);
                int tenant_id = rs.getInt(4);
                int time = rs.getInt(5);
                boolean overdue = rs.getBoolean(6);
                boolean complete = rs.getBoolean(7);
                request = new Request(id, type, numberWorkers, tenant_id, time, overdue, complete);
            }
            logger.info("read request by patient id");
        } catch (SQLException e) {
            throw new DAOException("Read request exception ", e);
        }
        return request;
    }



    
    /**
     * delete request
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void deleteRequest(Request request) throws DAOException {
        Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(DELETE_REQUEST_SQL);
            stmt.setInt(1, request.getId());
            stmt.execute();
            logger.info("deleted request");
        } catch (SQLException e) {
            throw new DAOException("Delete request exception ", e);
        }
    }

    /**
     * read request by overdue
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Request> readRequestByOverdue() throws DAOException {
    	ArrayList<Request> requests = new ArrayList<Request>();
         Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SELECT_REQUEST_BY_OVERDUE_SQL);
            stmt.setBoolean(1, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String type = rs.getString(2);
                int numberWorkers = rs.getInt(3);
                int tenant_id = rs.getInt(4);
                int time = rs.getInt(5);
                boolean overdue = rs.getBoolean(6);
                boolean complete = rs.getBoolean(7);
                Request request = new Request(id, type, numberWorkers, tenant_id, time, overdue, complete);
                requests.add(request);
            }
            logger.info("read request by overdue");
        } catch (SQLException e) {
            throw new DAOException("Read request by overdue exception ", e);
        }
        return requests;
    }


    /**
     * update request
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void updateOverdue(int id, boolean overdue) throws DAOException {
        Connection connection = null;
        try {
        	connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(UPDATE_REQUEST_OVERDUE_SQL);
            stmt.setBoolean(1, overdue);
            stmt.setInt(2, id);
            stmt.execute();
            logger.info("set overdue");
        } catch (SQLException e) {
            throw new DAOException("Set overdue exception ", e);
        }
    }
    
    /**
     * update request
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void updateComplete(int id) throws DAOException {
        Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(UPDATE_REQUEST_COMPLETE_SQL);
            stmt.setBoolean(1, true);
            stmt.setInt(2, id);
            stmt.execute();
            logger.info("set complete");
        } catch (SQLException e) {
            throw new DAOException("Set complete exception ", e);
        }
    }

	
}
