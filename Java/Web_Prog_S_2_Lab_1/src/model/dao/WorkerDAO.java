package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entity.Request;
import model.entity.Worker;
import model.exception.DAOException;

/**
 * worker dao class
 *
 * @author Козунов Алексей
 * @version 1.0.0
 */
public class WorkerDAO extends DAO {

	private static final String INSERT_WORKER_SQL = "insert into worker (profile, task) values(?, ?)";

    private static final String SELECT_ALL_WORKER_SQL = "select * from worker";

    private static final String SELECT_WORKER_BY_ID_SQL = "select * from worker where task_id = ?";

    private static final String UPDATE_WORKER_SQL = "update worker set task_id = ? where id = ?";


    /**
     * constructor
     *
     * @throws DAOException if Can't create connection
     */
    public WorkerDAO() throws DAOException {
        super();
    }
	
    /**
     * read doctor
     *
     * @return list of worker
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Worker> readWorkers() throws DAOException {
    	ArrayList<Worker> workers = new ArrayList<Worker>();
        Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_WORKER_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String profile = rs.getString(2);
                int taskId = rs.getInt(3);
                Worker worker = new Worker(id, profile, taskId);
                workers.add(worker);
            }
            logger.info("read worker");
        } catch (SQLException e) {
            throw new DAOException("Select worker exception ", e);
        } 
        return workers;
    }

    /**
     * read worker by id
     *
     * @return worker
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Worker> readWorkerById(int idTask) throws DAOException {
        ArrayList<Worker> workers = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(SELECT_WORKER_BY_ID_SQL);
            stmt.setInt(1, idTask);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String profile = rs.getString(2);
                int taskId = rs.getInt(3);
                Worker worker = new Worker(id, profile, taskId);
                workers.add(worker);
            }
            logger.info("read worker by id");
        } catch (SQLException e) {
            throw new DAOException("Delete worker exception ", e);
        }
        return workers;
    }

    /**
     * insert worker
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void insertWorker(Worker worker) throws DAOException {
        Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(INSERT_WORKER_SQL);
            stmt.setString(1, worker.getProfile());
            stmt.execute();
            logger.info("inserted worker");
        } catch (SQLException e) {
            throw new DAOException("Insert worker exception ", e);
        }
    }

    /**
     * deleter worker
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void updateWorker(Worker worker, int task) throws DAOException {
        Connection connection = null;
        try {
            connection = getDBConnector().getConnection();
            PreparedStatement stmt = connection.prepareStatement(UPDATE_WORKER_SQL);
            stmt.setInt(1, task);
            stmt.setInt(2, worker.getId());
            stmt.execute();
            logger.info("update worker");
        } catch (SQLException e) {
            throw new DAOException("Delete worker exception ", e);
        }
    }
	
}
