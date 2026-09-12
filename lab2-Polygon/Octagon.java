
public class Octagon implements  Polygon{

    protected double side;

    Octagon(double side){

        this.side = side;

    }


    @Override
    public double getArea() {
        return 2 * (1 + Math.sqrt(2)) * side * side;
    }


    @Override
    public double getPerimeter() {
        return side * 8;
    }
}
