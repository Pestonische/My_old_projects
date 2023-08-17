package controller.dao;

import model.entity.Booking;
import model.entity.Receipt;
import model.entity.Room;
import model.exception.DAOException;
import model.exception.DBConnectionException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ReceiptDAO extends DAO
{
    private static final Logger logger = LogManager.getLogManager().getLogger((ReceiptDAO.class).toString());

    private static final String SELECT_ALL_RECEIPT = "select * from receipt";
    private static final String SELECT_NOT_PAID_RECEIPT = "select * from receipt where is_paid = 0";
    private static final String SELECT_NOT_PAID_CLIENT_RECEIPT = "select * from receipt " +
            "where is_paid = 0 and client_id = ?";
    private static final String SELECT_NOT_AVAILABLE_ROOMS = "SELECT hotel.receipt.room_id, " +
            "hotel.booking.arrival_time, hotel.booking.departure_time FROM hotel.receipt \n" +
            "JOIN hotel.room ON hotel.receipt.room_id = hotel.room.id \n" +
            "JOIN hotel.booking ON hotel.booking.id = hotel.receipt.booking_id\n" +
            "WHERE hotel.room.capacity >= ?";
    private static final String UPDATE_BOOKING_STATUS = "UPDATE booking SET is_confirmed = ? WHERE id = ?";
    private static final String UPDATE_PAID_STATUS = "UPDATE receipt SET is_paid = ? WHERE client_id = ?";
    private static final String INSERT_RECEIPT = "insert into receipt (is_paid, total, client_id, room_id, booking_id) " +
            "values (?, ?, ?, ?, ?)";

    public ReceiptDAO() throws DAOException, DBConnectionException
    {
        super();
    }

    public double roomListPrice (List<Room> rooms, int index)
    {
        for (int i = 0; i < rooms.size(); i++)
        {
            if (rooms.get(i).getId() == index)
                return rooms.get(i).getPrice();
        }
        return 0;
    }

    public void confirmBooking() throws DAOException, DBConnectionException
    {
        BookingDAO bookingDAO = new BookingDAO();
        List<Booking> bookingList = bookingDAO.printBookings();

        //logger.info(bookingList);
        logger.info("Choose the entry to confirm:");
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();
        Booking item = null;
        for (int i = 0; i < bookingList.size(); i++)
        {
            if (bookingList.get(i).getId() == index)
            {
                item = bookingList.get(i);
                break;
            }
        }

        RoomDAO roomDAO = new RoomDAO();
        List<Room> roomList = roomDAO.readRooms(item.getGuests());

        Connection conn = null;

        try
        {
            conn = getDBConnector().getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_NOT_AVAILABLE_ROOMS);
            stmt.setInt(1, item.getGuests());
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int roomId = rs.getInt(1);
                Date arrivalDate = rs.getDate(2);
                Date departureDate = rs.getDate(3);

                if (item.getArrivalTime().compareTo(arrivalDate) < 0)
                    roomDAO.roomListRemove(roomList, roomId);
                else if (item.getDepartureTime().compareTo(departureDate) > 0)
                    roomDAO.roomListRemove(roomList, roomId);

                //if (l >= r') cont
                // else if (r <= l')
            }
            if (roomList.size() == 0)
            {
                logger.info("No suitable rooms :( Booking cancelled");
                stmt = conn.prepareStatement(UPDATE_BOOKING_STATUS);
                stmt.setInt(1, -1);
                stmt.setInt(2, item.getId());
                stmt.executeUpdate();
            }
            else
            {

                stmt = conn.prepareStatement(UPDATE_BOOKING_STATUS);
                stmt.setInt(1, 1);
                stmt.setInt(2, item.getId());
                stmt.executeUpdate();

                logger.info(roomList.toString());
                logger.info("Reminder! Requested type: " + item.getType() + ", guest(s): " + item.getGuests());
                logger.info("Choose  id of the most suitable room to confirm booking: ");
                int roomIndex = scan.nextInt();
                double totalPrice = item.getDuration() * roomListPrice(roomList, roomIndex);
                stmt = conn.prepareStatement(INSERT_RECEIPT);
                stmt.setInt(1, 0);
                stmt.setDouble(2, totalPrice);
                stmt.setInt(3, item.getClientId());
                stmt.setInt(4, roomIndex);
                stmt.setInt(5, item.getId());
                stmt.execute();
                logger.info("Successful update!");
                logger.info("Client #" + item.getClientId() +
                                " receives a receipt with total amount of " +  totalPrice);
            }
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

    }

    public List<Receipt> readReceipts() throws DAOException
    {
        List<Receipt> receipts = new ArrayList<Receipt>();
        Connection conn = null;

        try
        {
            conn = getDBConnector().getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_RECEIPT);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                int isPaid = rs.getInt(2);
                double price = rs.getDouble(3);
                int clientId = rs.getInt(4);
                int roomId = rs.getInt(5);
                int bookingId = rs.getInt(6);
                Receipt receipt = new Receipt(id, isPaid, price, clientId, roomId, bookingId);
                receipts.add(receipt);
            }
            logger.info("read receipts");
            logger.info(receipts.toString());
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
        return receipts;
    }

    public List<Receipt> getNotPaidReceipts() throws DAOException
    {
        List<Receipt> receipts = new ArrayList<Receipt>();
        Connection conn = null;

        try
        {
            conn = getDBConnector().getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_NOT_PAID_RECEIPT);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                int isPaid = rs.getInt(2);
                double price = rs.getDouble(3);
                int clientId = rs.getInt(4);
                int roomId = rs.getInt(5);
                int bookingId = rs.getInt(6);
                Receipt receipt = new Receipt(id, isPaid, price, clientId, roomId, bookingId);
                receipts.add(receipt);
            }

            for (Receipt r : receipts)
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
        return receipts;
    }

    public List<Receipt> payReceipt(int clientId) throws DAOException
    {
        List<Receipt> receipts = new ArrayList<Receipt>();
        Connection conn = null;

        try
        {
            conn = getDBConnector().getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_NOT_PAID_CLIENT_RECEIPT);
            stmt.setInt(1, clientId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt(1);
                int isPaid = rs.getInt(2);
                double price = rs.getDouble(3);
                int roomId = rs.getInt(5);
                int bookingId = rs.getInt(6);
                Receipt receipt = new Receipt(id, isPaid, price, clientId, roomId, bookingId);
                receipts.add(receipt);
            }

            for (Receipt r : receipts)
                logger.info(r.toString());

            Scanner scan = new Scanner(System.in);
            logger.info("\nChoose id of the receipt to pay:");
            int index = scan.nextInt();

            stmt = conn.prepareStatement(UPDATE_PAID_STATUS);
            stmt.setInt(1, 1);
            stmt.setInt(2, clientId);
            stmt.executeUpdate();

            logger.info("Successful payment!");
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
        return receipts;
    }

}

