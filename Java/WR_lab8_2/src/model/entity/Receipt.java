package model.entity;

public class Receipt
{
    private int id;
    private boolean isPaid;
    private double price;
    private int clientId;
    private int roomId;
    private int bookingId;

    public Receipt(int id, int isPaid, double price, int clientId, int roomId, int bookingId)
    {
        this.id = id;
        setPaid(isPaid);
        this.price = price;
        this.clientId = clientId;
        this.roomId = roomId;
        this.bookingId = bookingId;
    }

    public int getId() {
        return id;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getClientId() {
        return clientId;
    }

    public int getRoomId() {
        return roomId;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(int paid)
    {
        if (paid == 0)
            this.isPaid = false;
        else if (paid == 1)
            this.isPaid = true;
    }

    @Override
    public String toString()
    {
        return "\nReceipt #" + id + ": " +
                "is paid: "  + isPaid +
                ", price: "  + price +
                ", client id: "  + clientId +
                ", room id: " + roomId +
                ", booking id: " + bookingId;
    }
}
