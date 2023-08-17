package controller.dao;

import model.entity.Booking;
import model.exception.DAOException;
import model.exception.DBConnectionException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class BookingDAO extends DAO
{
    private static final Logger logger = LogManager.getLogManager().getLogger(BookingDAO.class.toString());

    private static final String SELECT_NEW_BOOKING = "select *, " +
            "datediff(departure_time, arrival_time) as diff from booking where is_confirmed = 0";
    private static final String INSERT_RACE_SQL = "insert into booking " +
            "(type, guests, arrival_time, departure_time, client_id, is_confirmed) values(?, ?, ?, ?, ?, ?)";

    public BookingDAO() throws DAOException, DBConnectionException
    {
        super();
    }

    public List<Booking> printBookings() throws DAOException
    {
        List<Booking> bookings = new ArrayList<Booking>();
        Connection conn = null;

        try
        {
            conn = getDBConnector().getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_NEW_BOOKING);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                String type = rs.getString(2);
                int guests = rs.getInt(3);
                Date arrivalTime = rs.getDate(4);
                Date departureTime = rs.getDate(5);
                int clientId = rs.getInt(6);
                int isConfirmed = rs.getInt(7);
                int duration = rs.getInt(8);

                Booking booking = new Booking(id, type, guests, arrivalTime,
                        departureTime, clientId, isConfirmed, duration);
                bookings.add(booking);
            }
            for (Booking b: bookings)
                logger.info(b.toString());
        }
        catch (SQLException e)
        {
            throw new DAOException("Table Room: error occured while executing a query", e);
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
                    throw new DAOException("Failed to return connection to DBConnector", e);
                }
            }
        }
        return bookings;
    }

    public void createBooking(Booking booking) throws DAOException
    {
        Connection conn = null;

        try
        {
            conn = getDBConnector().getConnection();
            PreparedStatement stmt = conn.prepareStatement(INSERT_RACE_SQL);
            stmt.setString(1, booking.getType());
            stmt.setInt(2, booking.getGuests());
            stmt.setDate(3, booking.getArrivalTime());
            stmt.setDate(4, booking.getDepartureTime());
            stmt.setInt(5, booking.getClientId());
            stmt.setInt(6, booking.getIsConfirmed());
            stmt.execute();
            logger.info("inserted booking");
        }
        catch (SQLException e)
        {
            throw new DAOException("Insert Booking exception ", e);
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
                    throw new DAOException("Failed to return connection to DBConnector ", e);
                }
            }
        }
    }

}
