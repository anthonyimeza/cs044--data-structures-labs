
public class Triangle implements Polygon {

    protected double sA, sB, sC;

        Triangle(double sA, double sB, double sC){

            this.sA = sA;
            this.sB = sB;
            this.sC = sC;

        }


    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sA) * (s - sB) * (s - sC));
    }

    @Override
    public double getPerimeter(){
        return sA + sB + sC;
    }

}
