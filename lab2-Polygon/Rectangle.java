
public class Rectangle extends Quadrilateral{

    Rectangle(double length, double width){

        super(length, width, length, width);
    }

    @Override
    public double getArea(){
        return this.sA * this.sB;
    }
}
