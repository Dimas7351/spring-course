package Practice;

public class Rectangle extends Shape{

    private double width;
    private double length;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public void setLength(double length){
        this.length = length;
    }

    public double getWidth(){
        return width;
    }

    public double getLength(){
        return length;
    }

    public double getArea() {
        return width*length;
    }


    public double getPerimeter() {
        return (width+length)*2;
    }

    public String toString(){
        return "Периметр прямоугольника = " + getPerimeter() +". Площадь прямоугольника = " + getArea();
    }
}
