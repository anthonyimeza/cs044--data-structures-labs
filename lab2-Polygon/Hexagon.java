
public class Hexagon implements  Polygon{

    protected double side;

    Hexagon(double side){

        this.side = side;

    }


    @Override
    public double getArea() {
        return (6 * (side * side)) / (4 * Math.tan(Math.PI / 6));
    }


    @Override
    public double getPerimeter() {
        return side * 6;
    }
}
