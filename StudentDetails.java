import java.util.*;
class Student {
    String name;
    int rollno;
    int marks;
    Student(String name,int rollno,int m) throws InvalidmarksException{
        if(m<0) throw new InvalidmarksException("Marks cannot be negative");
        this.name=name;
        this.rollno=rollno;
        this.marks=m;
    }
    void display(){
        System.out.println("Student name is: "+name);
        System.out.println("Student rollno is: "+rollno);
        System.out.println("Student marks is: "+marks);
    }
}
class Studentdetails{
    public static void main(String[] args){
        List<Student> li = new ArrayList<>();
        try{
        li.add(new Student("A",1,90));
        li.add(new Student("B",2,65));
        li.add(new Student("C",3,87));
        li.add(new Student("D",4,65));
        li.add(new Student("E",5,92));
        }
        catch(InvalidmarksException e){
            System.out.println();
        }
        
        for (Student s : li) {
            s.display();
        }
    }
}

class InvalidmarksException extends Exception{
    InvalidmarksException(String msg){
        super(msg);
    }
}