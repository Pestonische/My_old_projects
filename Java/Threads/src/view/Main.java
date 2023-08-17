package view;

import model.entities.Ship;
import model.entities.port.LockPort;
import model.entities.port.SynchronizedPort;
import model.entities.port.Port;
import model.thread.ShipThread;

import java.util.Random;

public class Main {

    private static final Object lock = new Object();

    private static void Work(Port port) {
        Thread[] threads = new Thread[20];
        Random random = new Random();

        System.out.println(port);
        for (int i = 0; i < 5; i++) {
            int maxCapacity = 10 + random.nextInt(50);
            int currentCapacity = random.nextInt(maxCapacity);

            Ship ship = new Ship(maxCapacity, currentCapacity, i + 1);
            System.out.println(ship);
            threads[i] = new Thread(new ShipThread(port, ship));
        }

        // run
        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }

        // wait
        for (int i = 0; i < 5; i++) {
            while (threads[i].isAlive()) {
                //System.out.println("waiting");
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("*************\nSynchronized variant");
        Work(new SynchronizedPort(2, 1000));
        System.out.println("\n*************\nLock variant");
        Work(new LockPort(2, 1000));
    }

}
