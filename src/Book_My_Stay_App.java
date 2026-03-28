import java.util.*;

class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

class BookingValidator {
    private static final List<String> validRoomTypes =
            Arrays.asList("Single", "Double", "Suite");

    public static void validate(String guestName, String roomType) throws InvalidBookingException {

        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        boolean isValidRoom = false;
        for (String type : validRoomTypes) {
            if (type.equalsIgnoreCase(roomType)) {
                isValidRoom = true;
                break;
            }
        }

        if (!isValidRoom) {
            throw new InvalidBookingException("Invalid room type selected.");
        }
    }
}

public class Book_My_Stay_App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Booking Validation");

        try {
            System.out.print("Enter guest name: ");
            String name = sc.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = sc.nextLine();

            BookingValidator.validate(name, roomType);

            System.out.println("Booking successful!");

        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }
}