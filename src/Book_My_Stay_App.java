import java.util.*;


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
public class Book_My_Stay_App {
    public static void main(String[] args){
        System.out.println("Booking Queue Request:");
        BookingRequestQueue bookingqueue=new BookingRequestQueue();
        Reservation r1=new Reservation("Nikhil","Single");
        Reservation r2=new Reservation("Sai","Double");
        Reservation r3=new Reservation("Arjun","Suite");
        bookingqueue.addRequest(r1);
        bookingqueue.addRequest(r2);
        bookingqueue.addRequest(r3);
        while(bookingqueue.hasPendingRequest()){
            Reservation r=bookingqueue.getNextRequest();
            System.out.println("Processing booking for Guest: "+r.getGuestName()+", Room Type: "+r.getRoomType());
        }
    }
}
