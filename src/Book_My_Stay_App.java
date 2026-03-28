import java.util.*;

class Reservation {
    private String reservationId;
    private String roomType;

    public Reservation(String reservationId, String roomType) {
        this.reservationId = reservationId;
        this.roomType = roomType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getRoomType() {
        return roomType;
    }
}

class Inventory {
    private Map<String, Integer> rooms;

    public Inventory() {
        rooms = new HashMap<>();
        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);
    }

    public void incrementRoom(String roomType) {
        rooms.put(roomType, rooms.get(roomType) + 1);
    }

    public int getAvailability(String roomType) {
        return rooms.get(roomType);
    }
}

class CancellationService {
    private Stack<String> rollbackStack;
    private Map<String, Reservation> reservationMap;
    private Inventory inventory;

    public CancellationService(Inventory inventory) {
        this.inventory = inventory;
        rollbackStack = new Stack<>();
        reservationMap = new HashMap<>();
    }

    public void addReservation(Reservation r) {
        reservationMap.put(r.getReservationId(), r);
    }

    public void cancelBooking(String reservationId) {

        if (!reservationMap.containsKey(reservationId)) {
            System.out.println("Invalid cancellation request.");
            return;
        }

        Reservation r = reservationMap.get(reservationId);

        rollbackStack.push(reservationId);

        inventory.incrementRoom(r.getRoomType());

        reservationMap.remove(reservationId);

        System.out.println("Booking Cancellation");
        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + r.getRoomType());

        System.out.println("\nRollback History (Most Recent First):");
        while (!rollbackStack.isEmpty()) {
            System.out.println("Released Reservation ID: " + rollbackStack.pop());
        }

        System.out.println("\nUpdated " + r.getRoomType() + " Room Availability: "
                + inventory.getAvailability(r.getRoomType()));
    }
}

public class Book_My_Stay_App {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        CancellationService service = new CancellationService(inventory);

        Reservation r1 = new Reservation("Single-1", "Single");

        service.addReservation(r1);

        service.cancelBooking("Single-1");
    }
}