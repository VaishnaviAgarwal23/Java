public class ShapeTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
 
        for (Shape s : shapes) {
            s.displayArea();   // must print correct area for each shape
        }
    }
}

abstract class Shape{
    abstract double Area();
    void displayArea(){
        System.out.println("Area = " + Area());
    }
} 

class Circle extends Shape{
    private double radius;
    Circle(double radius){
        this.radius=radius;
    }
    double Area(){
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape{
    private double length;
    private double width;
    Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }
    double Area(){
        return length*width;
    }
}