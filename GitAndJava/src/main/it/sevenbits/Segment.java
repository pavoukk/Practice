package main.it.sevenbits;

public class Segment {
    private Point point1;
    private Point point2;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }
    public double getLength(){
        return Math.sqrt(Math.pow(point1.getY() - point2.getY(), 2) + Math.pow(point1.getX() - point2.getX(), 2));
    }
}
