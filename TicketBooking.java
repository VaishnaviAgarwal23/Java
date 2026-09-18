import java.util.ArrayList;

public class TicketBooking{
    ArrayList<Integer> tickets=new ArrayList<>();
     public TicketBooking() {
        for (int i = 1; i <= 5; i++) {
            tickets.add(i);
        }
    }

    synchronized void bookTicket(String customer_name){
        if(tickets.isEmpty()){
            System.out.println("No tickets available");
            return;
        }
        int ticket=tickets.remove(0);
        System.out.println(ticket +" booked for customer "+customer_name);
    }
}

class BookingCounter implements Runnable{
    TicketBooking te;
    String customer_name;
    BookingCounter(TicketBooking te,String cn){
        this.te=te;
        this.customer_name=cn;
    }
    @Override 
    public void run(){
        te.bookTicket(customer_name);
    }

}

class Main {
    public static void main(String[] args)
            throws InterruptedException {
        TicketBooking booking = new TicketBooking();
        Thread t1 = new Thread(
            new BookingCounter(booking, "Customer 1"));
        Thread t2 = new Thread(
            new BookingCounter(booking, "Customer 2"));
        Thread t3 = new Thread(
            new BookingCounter(booking, "Customer 3"));
        Thread t4 = new Thread(
            new BookingCounter(booking, "Customer 4"));
        Thread t5 = new Thread(
            new BookingCounter(booking, "Customer 5"));
        Thread t6 = new Thread(
            new BookingCounter(booking, "Customer 6"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
    }
}