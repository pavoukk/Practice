package main.it.sevenbits;

public class Main {

    public static void main(String[] args) {
        Segment[] segments = new Segment[5];
        segments[0] = new Segment(new Point(0,5), new Point(1,1));
        segments[1] = new Segment(new Point(0, 5), new Point(5, 1));
        segments[2] = new Segment(new Point(2, 5), new Point(8, 1));
        segments[3] = new Segment(new Point(6, 6), new Point(3, 10));
        segments[4] = new Segment(new Point(4, 5), new Point(1, 1));
        double max = 0;
        for (int i = 0; i < segments.length; i++) {
            if (segments[i].getLength() > max) {
                max = segments[i].getLength();
            }
            System.out.println(segments[i].getLength());
        }
        System.out.println(max);

    }
}
