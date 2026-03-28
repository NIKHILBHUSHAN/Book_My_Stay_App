import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class Inventory {
    private Map<String, Integer> rooms;
    private Map<String, Integer> roomCounters;

    public Inventory() {
        rooms = new HashMap<>();
        roomCounters = new HashMap<>();

        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);

        roomCounters.put("Single", 1);
        roomCounters.put("Double", 1);
        roomCounters.put("Suite", 1);
    }

    public synchronized String allocateRoom(String roomType) {
        if (rooms.get(roomType) <= 0) {
            return null;
        }

        int count = roomCounters.get(roomType);
        String roomId = roomType + "-" + count;

        roomCounters.put(roomType, count + 1);
        rooms.put(roomType, rooms.get(roomType) - 1);

        return roomId;
    }

    public Map<String, Integer> getInventory() {
        return rooms;
    }
}

class BookingProcessor extends Thread {
    private Queue<Reservation> queue;
    private Inventory inventory;

    public BookingProcessor(Queue<Reservation> queue, Inventory inventory) {
        this.queue = queue;
        this.inventory = inventory;
    }

    public void run() {
        while (true) {
            Reservation r;

            synchronized (queue) {
                if (queue.isEmpty()) break;
                r = queue.poll();
            }

            String roomId = inventory.allocateRoom(r.roomType);

            if (roomId != null) {
                System.out.println("Booking confirmed for Guest: "
                        + r.guestName + ", Room ID: " + roomId);
            }
        }
    }
}

public class Book_My_Stay_App {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Concurrent Booking Simulation");

        Queue<Reservation> queue = new LinkedList<>();
        Inventory inventory = new Inventory();

        queue.add(new Reservation("Nikhil", "Single"));
        queue.add(new Reservation("Arjun", "Double"));
        queue.add(new Reservation("Sai", "Suite"));
        queue.add(new Reservation("Vedha", "Single"));

        Thread t1 = new BookingProcessor(queue, inventory);
        Thread t2 = new BookingProcessor(queue, inventory);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\nRemaining Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.getInventory().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}