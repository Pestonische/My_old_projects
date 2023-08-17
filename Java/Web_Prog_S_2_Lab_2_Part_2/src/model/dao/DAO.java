package model.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import model.exception.DAOException;
import model.exception.DBConnectionException;

/**
 * dao abstract class
 * @author Kozunov Alexei
 * @version 1.0.0
 */
public abstract class DAO {
	
	private static String PERSISTENCE_UNIT_NAME = "Test_Local";
	
	protected Logger logger = LogManager.getLogger("dao_layer");
	
	private EntityManagerFactory factory;
	
	protected EntityManagerFactory getEntityManagerFactory() {
        return factory;
    }
	/**
	 * constructor
	 */
	protected DAO() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        logger.info("Entity Manager Factory created " + PERSISTENCE_UNIT_NAME);
    }
	
}
