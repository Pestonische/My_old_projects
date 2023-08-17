package controller.dao;

import model.DBConnectionPool;
import model.exception.DAOException;
import model.exception.DBConnectionException;

abstract class DAO
{
    private DBConnectionPool pool;

    public DAO() throws DBConnectionException, DAOException
    {
        try
        {
            pool = DBConnectionPool.getInstance();
        }
        catch (DBConnectionException e)
        {
            throw new DAOException("Can't create DBConnectorPool ", e);
        }
    }

    protected DBConnectionPool getDBConnector()
    {
        return pool;
    }

}