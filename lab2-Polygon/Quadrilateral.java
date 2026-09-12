
public class Quadrilateral implements Polygon {

    protected double sA, sB, sC, sD;

        Quadrilateral(double sA, double sB, double sC, double sD){

            this.sA = sA;
            this.sB = sB;
            this.sC = sC;
            this.sD = sD;

        }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt((s - sA) * (s - sB) * (s - sC) * (s - sD));
    }


    @Override
    public double getPerimeter() {
            return sA + sB + sC + sD;
    }
}
