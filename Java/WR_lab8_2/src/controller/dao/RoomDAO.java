package controller.dao;

import model.entity.Room;
import model.exception.DAOException;
import model.exception.DBConnectionException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class RoomDAO extends DAO
{
    private static final Logger logger = LogManager.getLogManager().getLogger((RoomDAO.class).toString());

    private static final String SELECT_ALL_ROOM = "select * from room where capacity >= ? order by type, capacity";
    private static final String SELECT_TYPE_ROOM = "select * from room where " +
            "type = ? order by type, capacity";
    private static final String SELECT_NOT_AVAILABLE_ROOMS = "SELECT hotel.receipt.room_id, " +
            "hotel.booking.arrival_time, hotel.booking.departure_time FROM hotel.receipt \n" +
            "JOIN hotel.room ON hotel.receipt.room_id = hotel.room.id \n" +
            "JOIN hotel.booking ON hotel.booking.id = hotel.receipt.booking_id\n" +
            "WHERE hotel.room.capacity >= ? AND hotel.booking.is_confirmed = 1 AND hotel.room.type = ?";

    public RoomDAO() throws DAOException, DBConnectionException
    {
        super();
    }

    public void roomListRemove(List<Room> rooms, int index)
    {
        for (int i = 0; i < rooms.size(); i++)
        {
            if (rooms.get(i).getId() == index)
                rooms.remove(i);
        }
    }

    public List<Room> showAvailableRooms(Date arrivalTime, Date departureTime, String type) throws DAOException,
            DBConnectionException
    {
        RoomDAO roomDAO = new RoomDAO();
        List<Room> roomList = roomDAO.typeRooms(type);
        Connection conn = null;

        try
        {
            conn = getDBConnector().getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_NOT_AVAILABLE_ROOMS);
            stmt.setInt(1, 0);
            stmt.setString(2, type);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                System.out.println(roomList.size());
                int roomId = rs.getInt(1);
                Date arrDate = rs.getDate(2);
                Date depDate = rs.getDate(3);

                if (arrivalTime.compareTo(depDate) >= 0) {}
                else if (departureTime.compareTo(arrDate) <= 0) {}
                else
                    roomListRemove(roomList, roomId);

                //if (l >= r') cont
                // else if (r <= l')
            }
            if (roomList.size() == 0)
                logger.info("No rooms available.");
            for (Room r : roomList)
                logger.info(r.toString());
        }
        catch (SQLException e)
        {
            throw new DAOException("Table Receipt: error occured while executing a query", e);
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
        return roomList;
    }

    public List<Room> readRooms(int guests) throws DAOException
    {
        List<Room> rooms = new ArrayList<Room>();
        Connection conn = null;

        try
        {
            conn = getDBConnector().getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_ROOM);
            stmt.setInt(1, guests);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                int capacity = rs.getInt(2);
                double price = rs.getDouble(3);
                String type = rs.getString(4);
                Room room = new Room(id, capacity, price, type);
                rooms.add(room);
            }
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
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
        }
        return rooms;
    }

    public List<Room> typeRooms(String type) throws DAOException
    {
        List<Room> rooms = new ArrayList<Room>();
        Connection conn = null;

        try
        {
            conn = getDBConnector().getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_TYPE_ROOM);
            stmt.setString(1, type);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                int capacity = rs.getInt(2);
                double price = rs.getDouble(3);
                String roomType = rs.getString(4);
                Room room = new Room(id, capacity, price, roomType);
                rooms.add(room);
            }
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
                    throw new DAOException("Failed to return connection to db connector ", e);
                }
            }
            return rooms;
        }
    }
}
