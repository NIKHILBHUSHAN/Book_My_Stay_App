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
class RoomSearchService{
    public void searchAvailableRooms(RoomInventory rooms){
        HashMap<String,Integer> availability=rooms.getRoomAvailability();
        for (String room:availability.keySet()){
            System.out.println("Room: "+room);
            if(availability.get(room)>0) {
                if (room.equals("Single")) {
                    System.out.println("Beds: 1");
                    System.out.println("Size: 250ft");
                    System.out.println("Price per Night: 1500.0");
                    System.out.println("Available Rooms: " + availability.get(room));
                    System.out.println();
                }else if (room.equals("Double")) {
                    System.out.println("Beds: 2");
                    System.out.println("Size: 400ft");
                    System.out.println("Price per Night: 2500.0");
                    System.out.println("Available Rooms: "+availability.get(room));
                    System.out.println();
                }else if (room.equals("Suite")){
                    System.out.println("Beds: 3");
                    System.out.println("Size: 750ft");
                    System.out.println("Price per Night: 5000.0");
                    System.out.println("Available Rooms: "+availability.get(room));
                    System.out.println();
                }

            }
        }
    }
}
public class Book_My_Stay_App {
    public static void main(String[] args){
        RoomInventory rooms=new RoomInventory();
        RoomSearchService search=new RoomSearchService();
        System.out.println("Room search\n");
        search.searchAvailableRooms(rooms);
    }
}
