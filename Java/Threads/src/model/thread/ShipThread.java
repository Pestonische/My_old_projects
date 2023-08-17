package model.thread;

import model.entities.Ship;
import model.entities.port.Port;


/**
 * Class-Thread for Ship
 */
public class ShipThread implements Runnable{

    /**
     * private field ship
     */
    private Ship ship;

    /**
     * private field port
     */
    private Port port;

    /**
     * Constructor with parameters
     * @param port - port
     * @param ship - ship in this port
     */
    public ShipThread(Port port, Ship ship) {
        this.ship = ship;
        this.port = port;
    }

    /**
     * Method run for thread
     */
    @Override
    public void run() {
        // port
        if (!port.port()) {
            System.out.println("Berth cannot accept " + ship);
            return;
        }

        // try place everything to port
        if (ship.hasCargo()) {
            System.out.println("Ship " + ship.getNumber() + " try place " + ship.getCurrentCapacity() + " to port");
            if (port.place(ship.getCurrentCapacity())) {
                ship.setCurrentCapacity(0);
            }
            System.out.println("********Current weight on port: " + port.getCurrentCapacity());
            showShipCurrentWeight();

        }

        // try load
        if (ship.hasSpace()) {
            System.out.println("Port try load " + ship.getAvailableSpace() + " to " + ship.getNumber() + " ship");
            int capacity = port.load(ship.getAvailableSpace());
            ship.addCargo(capacity);
            System.out.println("Added capacity to ship " + ship.getNumber() + " - " + capacity);
            System.out.println("********Current capacity on port: " + port.getCurrentCapacity());
            showShipCurrentWeight();
        }


        port.leave();

        System.out.println("Ship " + ship.getNumber() + " leave port");
        System.out.println("********Current capacity on port: " + port.getCurrentCapacity());

    }

    /**
     * Show-method for current capacity of ship
     */
    public void showShipCurrentWeight() {
        System.out.println("________Current capacity of ship " + ship.getNumber() + ": " + ship.getCurrentCapacity());
    }

}
