package model.entities.port;

public interface Port {

    /**
     * Port load cargo to ship
     * @param max - capacity
     * @return - loaded capacity
     */
    public int load(int max);

    /**
     * Ship place some cargo to port
     * @param capacity
     * @return - capacity
     */
    public boolean place(int capacity);

    /**
     * Ship enter to one berth in port
     * @return - true if ship enter, false if not
     */
    public boolean port();

    /**
     * Ship leave port
     */
    public void leave();

    /**
     * Get-method for current capacity of port
     * @return
     */
    public int getCurrentCapacity();
}
