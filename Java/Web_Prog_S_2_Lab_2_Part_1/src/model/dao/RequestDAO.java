package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.Tenant;
import model.entity.Worker;
import model.entity.Request;
import model.exception.DAOException;
import model.exception.DBConnectionException;

/**
 * Request dao class
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */
public class RequestDAO extends DAO {
    
    /**
     * constructor
     *
     * @throws DAOException if Can't create connection
     */
    public RequestDAO() throws DAOException {
        super();
    }

    /**
     * read Request
     *
     * @return list of Request
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Request> readRequest() throws DAOException {
        ArrayList<Request> request = new ArrayList<Request>();
        EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();

            request = (ArrayList<Request>) entityManager.createNamedQuery("readRequests")
                    .getResultList();
            logger.info("read Request");
        } catch (Exception e) {
            throw new DAOException("failed to read Request", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return request;
    }

    /**
     * read Request by patient id
     *
     * @return Request
     * @throws DAOException if Can't execute query or problems with connection
     */
    public Request selectRequestById(int _id) throws DAOException {
        Request Request = null;
        EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();

        	Request = entityManager.createNamedQuery("readRequest", Request.class)
                    .setParameter("id", _id)
                    .getSingleResult();
            logger.info("read Request by id");
        } catch (Exception e) {
            throw new DAOException("failed to read Request by id", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return Request;
    }

    /**
     * insert Request
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void insertRequest(Request request) throws DAOException {
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(request);
            transaction.commit();
            logger.info("inserted Request");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to insert Request", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }
    
    /**
     * delete Request
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void deleteRequest(Request request) throws DAOException {
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.createNamedQuery("deleteRequest")
                    .setParameter("id", request.getId())
                    .executeUpdate();
            transaction.commit();
            logger.info("deleted Request");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to delete Request", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    /**
     * read Request by doctor
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Request> readRequestByOverdue() throws DAOException {
    	ArrayList<Request> Request = new ArrayList<Request>();
    	EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();

        	Request = (ArrayList<Request>) entityManager.createNamedQuery("readRequestByOverdue")
                    .setParameter("overdue", true)
                    .getResultList();
            logger.info("read Request by overdue");
        } catch (Exception e) {
            throw new DAOException("failed to read Request by doctor id", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return Request;
    }

    public void updateOverdue(int _id, boolean overdue) throws DAOException {
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.createNamedQuery("readRequestOverdue")
                    .setParameter("overdue", overdue)
                    .setParameter("id", _id)
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


    public void updateComplete(int _id) throws DAOException {
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.createNamedQuery("updateRequestComplete")
                    .setParameter("complete", true)
                    .setParameter("id", _id)
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

	
}
