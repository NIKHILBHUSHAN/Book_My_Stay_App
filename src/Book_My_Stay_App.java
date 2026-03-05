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

        System.out.println(rooms.getRoomAvailability());
    }
}
