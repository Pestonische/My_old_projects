package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.Worker;
import model.exception.DAOException;
import model.exception.DBConnectionException;

/**
 * Worker dao class
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */
public class WorkerDAO extends DAO {
    
    /**
     * constructor
     *
     * @throws DAOException if Can't create connection
     */
    public WorkerDAO() {
        super();
    }
	
    /**
     * read Worker
     *
     * @return list of Workers
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Worker> readWorkers() throws DAOException {
    	ArrayList<Worker> workers = new ArrayList<Worker>();
    	EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
        	workers = (ArrayList<Worker>) entityManager.createNamedQuery("readWorkers")
                    .getResultList();
            logger.info("read Workers");
        } catch (Exception e) {
            throw new DAOException("Read Workers exception ", e);
        } finally {
        	if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return workers;
    }

    /**
     * read Worker by id
     *
     * @return Worker
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Worker> readWorkerById(int id) throws DAOException {
        ArrayList<Worker> workers = new ArrayList<>();
    	EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            workers = (ArrayList<Worker>) entityManager.createNamedQuery("readWorkersById")
                    .setParameter("id", id)
                    .getSingleResult();
            logger.info("read Worker by id");
        } catch (Exception e) {
            throw new DAOException("Read Workers exception ", e);
        } finally {
        	if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return workers;
    }
    /**
     * update Worker
     *
     * @return Worker
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void updateTask(Worker worker, int task) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.createNamedQuery("updateWorkersTaskId")
                    .setParameter("task_id", task)
                    .setParameter("id", worker.getId())
                    .executeUpdate();
            transaction.commit();
            logger.info("update");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to update", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }
    /**
     * insert Worker
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void insertWorker(Worker worker) throws DAOException {
    	EntityManager entityManager = null;
    	EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(worker);
            transaction.commit();
            logger.info("inserted Worker");
        } catch (Exception e) {
        	if (transaction != null && transaction.isActive())
                transaction.rollback();
        	throw new DAOException("Read Workers exception ", e);
        } finally {
        	if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }
	
}
