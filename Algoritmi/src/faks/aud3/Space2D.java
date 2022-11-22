package faks.aud3;

public class Space2D {
    Point [] points;
    private final double INF = 1000000;

    public Space2D(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }



    public double minDistance(){
        double MIN = INF;
        for (int i=0;i<(points.length-1);i++){
            for (int j=i+1; j< points.length;j++){

                MIN = Math.min(MIN,points[i].distance(points[j]));
            }
        }
        return MIN;
    }

    public static void main(String[] args) {
        Point point1 = new Point(1,5.5);
        Point point2 = new Point(1.2,1.5);
        Point point3 = new Point(2,4.5);
        Point point4 = new Point(3,9.5);

        Point[] points = {point1,point2,point3,point4};
        Space2D space2D = new Space2D(points);
        System.out.printf("%.2f\n", space2D.minDistance());
    }
}
