package faks.aud3;

public class Point {
    private double x;
    private double y;
    private double MIN = 1000000;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double distance(Point b){

        return Math.sqrt((this.getX() - b.getX()) * (this.getX() - b.getX()) +
                (this.getY() - b.getY()) * (this.getY() - b.getY()));

    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
