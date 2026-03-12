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
public class Book_My_Stay_App {
    public static void main(String[] args){
        RoomInventory rooms=new RoomInventory();
        System.out.println("Hotel Room Inventory Status\n");
        HashMap<String,Integer> map=rooms.getRoomAvailability();
        for(String room:map.keySet()){
            System.out.println("Room: "+room);
            if(room.equals("Single")){
                System.out.println("Beds: 1");
                System.out.println("Size: 250ft");
                System.out.println("Price per Night: 1500.0");
                System.out.println("Available Rooms: "+map.get(room));
                System.out.println();
            } else if (room.equals("Double")) {
                System.out.println("Beds: 2");
                System.out.println("Size: 400ft");
                System.out.println("Price per Night: 2500.0");
                System.out.println("Available Rooms: "+map.get(room));
                System.out.println();
            }else if (room.equals("Suite")){
                System.out.println("Beds: 3");
                System.out.println("Size: 750ft");
                System.out.println("Price per Night: 5000.0");
                System.out.println("Available Rooms: "+map.get(room));
                System.out.println();
            }
        }
        rooms.updateAvailability("suite",10);

    }
}
