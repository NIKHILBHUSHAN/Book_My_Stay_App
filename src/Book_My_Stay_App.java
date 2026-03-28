import java.io.*;
import java.util.*;

class Inventory implements Serializable {
    private Map<String, Integer> rooms;

    public Inventory() {
        rooms = new HashMap<>();
        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);
    }

    public Map<String, Integer> getRooms() {
        return rooms;
    }
}

class PersistenceService {
    private static final String FILE_NAME = "inventory.dat";

    public void saveInventory(Inventory inventory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(inventory);
            System.out.println("Inventory saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving inventory.");
        }
    }

    public Inventory loadInventory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Inventory) ois.readObject();
        } catch (Exception e) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return new Inventory();
        }
    }
}

public class Book_My_Stay_App {
    public static void main(String[] args) {

        System.out.println("System Recovery");

        PersistenceService service = new PersistenceService();

        Inventory inventory = service.loadInventory();

        System.out.println("\nCurrent Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.getRooms().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        service.saveInventory(inventory);
    }
}