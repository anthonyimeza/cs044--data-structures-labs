
public class Pentagon implements Polygon {

    protected double side;

    Pentagon(double side){

        this.side = side;

    }


    @Override
    public double getArea() {
        return (5 * side * side) / (4.0 * Math.tan(Math.PI / 5));
    }


    @Override
    public double getPerimeter() {
        return side * 5;
    }
}

