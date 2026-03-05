abstract class Room{
    protected int numberOfBeds;
    protected int squareFeet;
    protected double chargePerNight;
    public Room(int numberOfBeds,int squareFeet,double chargePerNight){
        this.numberOfBeds=numberOfBeds;
        this.squareFeet=squareFeet;
        this.chargePerNight=chargePerNight;
    }
    abstract void displayRoomDetails();


}
class SingleRoom extends Room{
    public SingleRoom(){
        super(1,250,1500.0);
    }
    public void displayRoomDetails(){
        System.out.println("Single Room:");
        System.out.println("Beds:"+numberOfBeds);
        System.out.println("size:"+squareFeet+"ft");
        System.out.println("Price Per Night:"+chargePerNight);
        System.out.println("Available:5\n");
    }
}
class DoubleRoom extends Room{
    public DoubleRoom(){
        super(2,400,2500.0);
    }
    public void displayRoomDetails(){
        System.out.println("Double Room:");
        System.out.println("Beds:"+numberOfBeds);
        System.out.println("size:"+squareFeet+"ft");
        System.out.println("Price Per Night:"+chargePerNight);
        System.out.println("Available:3\n");
    }

}
class SuiteRoom extends Room{
    public SuiteRoom(){
        super(3,750,5000.0);
    }
    public void displayRoomDetails(){
        System.out.println("Suite Room:");
        System.out.println("Beds:"+numberOfBeds);
        System.out.println("size:"+squareFeet+"ft");
        System.out.println("Price Per Night:"+chargePerNight);
        System.out.println("Available:2\n");
    }
}
public class Book_My_Stay_App {
    public static void main(String[] args){
        SingleRoom room1=new SingleRoom();
        DoubleRoom room2=new DoubleRoom();
        SuiteRoom room3=new SuiteRoom();
        System.out.println(("Hotel Room Initialization\n"));
        room1.displayRoomDetails();
        room2.displayRoomDetails();
        room3.displayRoomDetails();
    }
}
