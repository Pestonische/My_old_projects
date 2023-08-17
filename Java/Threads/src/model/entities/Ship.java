package model.entities;

public class Ship {

    /**
     * max capacity of ship
     */
    private int maxCapacity;

    /**
     * private field of current capacity of ship
     */
    private int currentCapacity;

    /**
     * private field of number of ship
     */
    private int number;

    /**
     * Constructor with parameters
     * @param maxCapacity - max capacity
     * @param currentCapacity - current capacity
     * @param number - number of ship
     */
    public Ship(int maxCapacity, int currentCapacity, int number) {
        if (maxCapacity < 0)
            throw new IllegalArgumentException("Max capacity of ship must be > 0!");
        this.maxCapacity = maxCapacity;

        if (currentCapacity < 0 || currentCapacity > maxCapacity)
            throw new IllegalArgumentException("Invalid value for current capacity for ship!");
        this.currentCapacity = currentCapacity;

        if (number < 0)
            throw new IllegalArgumentException("Invalid value for number of ship!");
        this.number = number;
    }

    /**
     * Get-method for max capacity
     * @return - max capacity
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Get-method for number of ship
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Set-method for max capacity
     * @param maxCapacity - max capacity
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * Get-Method for current capacity
     * @return - current capacity of ship
     */
    public int getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * Set-method for current capacity
     * @param currentCapacity - current capacity
     */
    public void setCurrentCapacity(int currentCapacity) {
        if (currentCapacity < 0 || currentCapacity > maxCapacity)
            throw new IllegalArgumentException("Invalid value for current capacity for ship!");

        this.currentCapacity = currentCapacity;
    }

    /**
     * Method that check сargo in ship
     * @return
     */
    public boolean hasCargo() {
        return currentCapacity > 0;
    }

    /**
     * Method that check space in ship
     * @return
     */
    public boolean hasSpace() {
        return currentCapacity < maxCapacity;
    }

    /**
     * Method that get available space in ship
     * @return maxCapacity - currentCapacity
     */
    public int getAvailableSpace() {
        return maxCapacity - currentCapacity;
    }

    /**
     * Add cargo to ship
     * @param capacity - try to add this capacity
     */
    public void addCargo(int capacity) {
        if (currentCapacity + capacity > maxCapacity)
            throw new IllegalArgumentException("You try to load big value!");
        currentCapacity += capacity;
    }

    @Override
    public String toString() {
        String str = "\n********\nShip " + number + ":\nCurrent capacity: " + currentCapacity + "\nMax capacity: " + maxCapacity;
        return str;
    }
}
