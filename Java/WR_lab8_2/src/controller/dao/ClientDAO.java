package controller.dao;

import model.entity.Client;
import model.exception.DAOException;
import model.exception.DBConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ClientDAO extends DAO
{
    private static final Logger logger = LogManager.getLogManager().getLogger(ClientDAO.class.toString());

    private static final String SELECT_ALL_CLIENTS = "select * from client";

    public ClientDAO() throws DAOException, DBConnectionException
    {
        super();
    }

    public List<Client> readClients() throws DAOException
    {
        List<Client> clients = new ArrayList<Client>();
        Connection conn = null;

        try
        {
            conn = getDBConnector().getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_CLIENTS);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Client client = new Client(id, name);
                clients.add(client);
            }
            logger.info("read clients");
            logger.info(clients.toString());
        }
        catch (SQLException e)
        {
            throw new DAOException("Table Client: error occured while executing a query", e);
        }
        catch (DBConnectionException e)
        {
            throw new DAOException("Failed to get connection from DBConnector", e);
        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    getDBConnector().releaseConnection(conn);
                }
                catch (DBConnectionException e)
                {
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
        return clients;
    }
}
