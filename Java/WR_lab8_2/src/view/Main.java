package view;

import controller.dao.BookingDAO;
import controller.dao.ReceiptDAO;
import controller.dao.RoomDAO;
import model.DBConnectionPool;
import model.entity.Booking;
import model.exception.DAOException;
import model.exception.DBConnectionException;

import java.sql.Date;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main
{
    private static final Logger logger = LogManager.getLogManager().getLogger(Main.class.toString());

    public static void main(String[] args) throws DAOException, DBConnectionException
    {
        Scanner scan = new Scanner(System.in);
        RoomDAO roomDAO = new RoomDAO();
        ReceiptDAO receiptDAO = new ReceiptDAO();
        BookingDAO bookingDAO = new BookingDAO();

        while (true)
        {
            logger.info("Welcome to the KKW Hotel! Choose the action to perform: ");
            logger.info("1) Print all available rooms of certain type at defined time");
            logger.info("2) Print all unpaid receipts");
            logger.info("3) Create a booking");
            logger.info("4) Confirm a booking and send a receipt");
            logger.info("5) Print all unconfirmed bookings");
            logger.info("6) Pay receipts");
            logger.info("0) Exit\n");

            logger.info("\nYour choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice)
            {
                case 1:
                    logger.info("Choose one type from following: family, single, standart, suite");
                    String type = scan.nextLine();
                    logger.info("Write arrival date in yyyy-mm-dd format");
                    String arrivalTime = scan.nextLine();
                    logger.info("Write departure date in yyyy-mm-dd format");
                    String departureTime = scan.nextLine();
                    roomDAO.showAvailableRooms(
                            Date.valueOf(arrivalTime), Date.valueOf(departureTime), type);
                    break;
                case 2:
                    receiptDAO.getNotPaidReceipts();
                    break;
                case 3:
                    logger.info("Choose one type from following: family, single, standart, suite");
                    type = scan.nextLine();
                    logger.info("Write numbers of guests");
                    int guests = scan.nextInt();
                    scan.nextLine();
                    logger.info("Write arrival date in yyyy-mm-dd format");
                    arrivalTime = scan.nextLine();
                    logger.info("Write departure date in yyyy-mm-dd format");
                    departureTime = scan.nextLine();

                    Booking item = new Booking(type, guests, Date.valueOf(arrivalTime),
                            Date.valueOf(departureTime), 1, 0);
                    bookingDAO.createBooking(item);
                    break;
                case 4:
                    receiptDAO.confirmBooking();
                    break;
                case 5:
                    bookingDAO.printBookings();
                    break;
                case 6:
                    receiptDAO.payReceipt(1);
                    break;
                case 0:
                    DBConnectionPool.getInstance().closeDBConnector();
                    System.exit(0);
                default:
                    logger.info("Smth went wrong, try again.\n");
                    break;
            }
            logger.info("Operation has done.");
            scan.nextLine();

        }
    }
}
