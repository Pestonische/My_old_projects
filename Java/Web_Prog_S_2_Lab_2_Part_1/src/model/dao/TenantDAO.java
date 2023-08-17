package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.Tenant;
import model.exception.DAOException;
import model.exception.DBConnectionException;

/**
 * Tenant dao class
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */
public class TenantDAO extends DAO {
    
    /**
     * constructor
     *
     * @throws DAOException if Can't create connection
     */
    public TenantDAO() throws DAOException {
        super();
    }
	
    /**
     * read Tenant
     *
     * @return list of Tenants
     * @throws DAOException if Can't execute query or problems with connection
     */
    public ArrayList<Tenant> readTenants() throws DAOException {
    	ArrayList<Tenant> Tenants = new ArrayList<Tenant>();
    	EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
        	Tenants = (ArrayList<Tenant>) entityManager.createNamedQuery("readTenants")
                    .getResultList();
            logger.info("read Tenants");
        } catch (Exception e) {
            throw new DAOException("failed to read Tenants", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return Tenants;
    }

    /**
     * read Tenant by id
     *
     * @return Tenant
     * @throws DAOException if Can't execute query or problems with connection
     */
    public Tenant readTenantById(int id) throws DAOException {
    	Tenant Tenant = null;
    	EntityManager entityManager = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();

        	Tenant = entityManager.createNamedQuery("readTenant", Tenant.class)
                    .setParameter("id", id)
                    .getSingleResult();
            logger.info("read Tenant by id");
        } catch (Exception e) {
            throw new DAOException("failed to read Tenant", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return Tenant;
    }

    /**
     * insert Tenant
     *
     * @throws DAOException if Can't execute query or problems with connection
     */
    public void insertTenant(Tenant tenant) throws DAOException {
    	EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
        	entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(tenant);
            transaction.commit();
            logger.info("inserted Tenant");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("failed to insert Tenant", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }


    
}
