package model.entity;

public class Room
{
    private int id;
    private int capacity;
    private double price;
    private String type;

    public Room(int id, int capacity, double price, String type)
    {
        this.id = id;
        this.capacity = capacity;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice()
    {
        return price;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public String getType()
    {
        return type;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setType(String type)
    {
        this.type = type;
    }


    @Override
    public String toString()
    {
        return "\nRoom #" + id + ": " +
                "price: "  + price +
                ", capacity: " + capacity +
                ", type: " + type;
    }
}
