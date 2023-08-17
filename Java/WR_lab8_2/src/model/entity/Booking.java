package model.entity;

import java.sql.Date;

public class Booking
{
    private int id;
    private String type;
    private int guests;
    private Date arrivalTime;
    private Date departureTime;
    private int duration;
    private int clientId;
    private int isConfirmed;

    public Booking (int id, String type, int guests, Date arrivalTime, Date departureTime,
                    int clientId, int isConfirmed, int duration)
    {
        this.id = id;
        this.type = type;
        this.guests = guests;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.clientId = clientId;
        this.isConfirmed = isConfirmed;
        this.duration = duration;
    }

    public Booking (String type, int guests, Date arrivalTime, Date departureTime, int clientId, int isConfirmed)
    {
        this.type = type;
        this.guests = guests;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.clientId = clientId;
        this.isConfirmed = isConfirmed;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public int getGuests() {
        return guests;
    }

    public int getClientId() {
        return clientId;
    }

    public int getDuration() {
        return duration;
    }

    public int getIsConfirmed() {
        return isConfirmed;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setIsConfirmed(int isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    @Override
    public String toString()
    {
        String status = "";
        if (isConfirmed == 0)
            status = "not yet confirmed";
        else if (isConfirmed == 1)
            status = "accepted";
        else if (isConfirmed == -1)
            status = "declined";

        return "\nBooking #" + id + ": " +
                "type: "  + type +
                ", guest(s): " + guests +
                ", arrival time: " + arrivalTime +
                ", departure time: " + departureTime +
                ", client id: " + clientId +
                ", confirmation status: " + status;
    }
}
