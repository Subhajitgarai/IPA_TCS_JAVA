package IPA44;
import java.util.*;
class Rectangle{
    private double length;
    private double breadth;
    public Rectangle(double length, double breadth){
        this.length=length;
        this.breadth=breadth;
    }
    public double getLength(){
        return this.length;
    }
    public double getBreadth(){
        return this.breadth;
    }
}
class Ipa44{
    public static double calculateArea(Rectangle rec){
        double area=rec.getLength()*rec.getBreadth();
        return area;

    }
    public static double calculatePerimeter(Rectangle rec){
        double peri=2*(rec.getLength()+rec.getBreadth());
        return peri;

    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Rectangle rec1=new Rectangle(sc.nextDouble(),sc.nextDouble());
        Rectangle rec2=new Rectangle(sc.nextDouble(),sc.nextDouble());
        System.out.println(calculateArea(rec1));
        System.out.println(calculatePerimeter(rec1));
        System.out.println(calculateArea(rec2));
        System.out.println(calculatePerimeter(rec2));
    }
}