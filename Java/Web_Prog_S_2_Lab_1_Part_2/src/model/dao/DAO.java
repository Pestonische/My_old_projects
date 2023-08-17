package model.dao;


import model.JDBConnectorPool;
import model.exception.DAOException;
import model.exception.DBConnectionException;

import java.util.logging.Logger;

/**
 * dao abstract class
 * @author Козунов Алексей
 * @version 1.0.0
 */
public abstract class DAO {

    private JDBConnectorPool dbc;

    protected Logger logger = Logger.getLogger("dao_layer");

    protected JDBConnectorPool getDBConnector() {
        logger.info("requested to db connector");
        return dbc;
    }

    /**
     * constructor
     * @throws DAOException if Can't create connection
     */
    protected DAO() throws DAOException {
        try {
            dbc = JDBConnectorPool.getInstance();
            logger.info("Connection to database from dao inited");
        } catch (DBConnectionException e) {
            throw new DAOException("Can't create DBConnectorPool ", e);
        }
    }

}
