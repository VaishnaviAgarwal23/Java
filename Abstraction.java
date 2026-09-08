interface Payment{
    void make_payment(); //this method is abstract and public
    static void display(){
        System.out.println("Payment Successful");
    }
}
class UPI implements Payment{
    public void make_payment(){
        System.out.println("Payment using upi");
    }

}
class Creditcard implements Payment{
    public void make_payment(){
        System.out.println("Payment using credit card");
    }
}

public class Abstraction{
    public static void main(String[] args){
        Payment obj = new UPI();
        Payment.display();
        obj.make_payment();
        Payment obj1= new Creditcard();
        obj1.make_payment();
    }
}
