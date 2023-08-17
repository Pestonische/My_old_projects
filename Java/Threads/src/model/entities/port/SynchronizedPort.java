package model.entities.port;

public class SynchronizedPort implements Port {

    private int berthCount;
    private int maxCapacity;
    private int currentCapacity = 0;
    private int shipsInBerhts = 0;

    public SynchronizedPort(int berthCount, int maxCapacity) {
        this.berthCount = berthCount;
        this.maxCapacity = maxCapacity;
    }

    public int load(int max) {
        int retries = 100;

        while (retries-- > 0) {
            int cargo = tryLoad(max);
            if (cargo > 0) {
                return cargo;
            }
        }
        return 0;
    }

    public boolean place(int weight) {
        int retries = 100;
        while (retries-- > 0) {
            if (tryPlace(weight)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean port() {
        while (!(shipsInBerhts < berthCount)) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        shipsInBerhts++;
        return true;
    }

    public synchronized void leave() {
        shipsInBerhts--;
        notifyAll();
    }

    private synchronized int tryLoad(int max) {
        if (currentCapacity >= max) {
            currentCapacity -= max;
            return max;
        }
        if (max > currentCapacity) {
            int weight = currentCapacity;
            currentCapacity = 0;
            return weight;
        }
        return 0;
    }

    @Override
    public int getCurrentCapacity() {
        return currentCapacity;
    }

    private synchronized boolean tryPlace(int weight) {
        if (currentCapacity + weight > maxCapacity) {
            return false;
        }
        currentCapacity += weight;
        return true;
    }

    @Override
    public String toString() {
        String str = "\n=============Port=============\nCount of berths: " + berthCount + "\nMax capacity: " + maxCapacity;
        return str;
    }
}
