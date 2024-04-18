package Practice;
import java.lang.Math;

public class Circle extends Shape{
    private double radius;
    public final double PI = Math.PI;

    public Circle(double radius){
        this.radius = radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return PI*radius*radius;
    }

    public double getPerimeter(){
        return 2*PI*radius;
    }

    public String toString(){
        return "Периметр окружности = " + getPerimeter() +". Площадь окружности = " + getArea();
    }
}
