import java.util.*;

class RoomInventory{
    private HashMap<String,Integer> roomAvailability;
    public RoomInventory(){
        roomAvailability=new HashMap<>();
        initializeInventory();
    }
    private void initializeInventory(){
        roomAvailability.put("Single",5);
        roomAvailability.put("Double",3);
        roomAvailability.put("Suite",2);


    }
    public HashMap<String,Integer> getRoomAvailability(){
        return roomAvailability;
    }
    public void updateAvailability(String roomtype,int count){
        roomAvailability.put(roomtype,count);
    }

}
class Reservation{
    private String guestName,roomType;
    public Reservation(String guestName,String roomType){
        this.guestName=guestName;
        this.roomType=roomType;
    }
    public String getGuestName(){
        return guestName;
    }
    public String getRoomType(){
        return roomType;
    }
}
class BookingRequestQueue{
    private Queue<Reservation> requestQueue;
    public BookingRequestQueue(){requestQueue=new LinkedList<>();}
    public void addRequest(Reservation reservation){
        requestQueue.offer(reservation);
    }
    public Reservation getNextRequest(){
        return requestQueue.poll();
    }
    public boolean hasPendingRequest(){
        return !requestQueue.isEmpty();
    }
}
class RoomAllocationService{
    Random rand=new Random();
    private Set<String> allocatedRoomIds;
    private Map<String,Set<String>> assignedRoomsByType;
    public RoomAllocationService(){
        assignedRoomsByType=new HashMap<>();
        allocatedRoomIds=new HashSet<>();
    }
    public void allocateRoom(Reservation reservation,RoomInventory inventory){
        String roomId=generateRoomId(reservation.getRoomType());
        HashMap<String,Integer> room=inventory.getRoomAvailability();
        int updatedInventory=room.get(reservation.getRoomType())-1;
        inventory.updateAvailability(reservation.getRoomType(),updatedInventory);
        allocatedRoomIds.add(roomId);

        System.out.println("Booking Confirmed for Guest:"+reservation.getGuestName()+", RoomID:"+roomId);
    }
    private String generateRoomId(String roomType){

        return roomType+"-"+rand.nextInt(100)+1;
    }

}
public class Book_My_Stay_App {
    public static void main(String[] args){
        System.out.println("Room Allocation Processing:");
        BookingRequestQueue bookingQueue=new BookingRequestQueue();
        RoomInventory inventory=new RoomInventory();
        RoomAllocationService allocationService=new RoomAllocationService();

        Reservation r1=new Reservation("Nikhil","Single");
        Reservation r2=new Reservation("Sai","Double");
        Reservation r3=new Reservation("Arjun","Suite");
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);
        while(bookingQueue.hasPendingRequest()){
            Reservation r=bookingQueue.getNextRequest();
            allocationService.allocateRoom(r,inventory);
        }
        System.out.println(inventory.getRoomAvailability());
    }
}
