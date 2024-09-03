/* 
 Author: Ricky Duncan
SDEV140-11
06/21/2024
Assignment: Module 2 Programming Assignment 1
*/

public class MyPoint {
    private double x;
    private double y;

    // No-arg constructor that creates a point (0, 0)
    public MyPoint() {
        this(0, 0);
    }

    // Constructor that constructs a point with specified coordinates
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter methods for x and y
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Method to calculate distance from this point to another specified MyPoint
    public double distance(MyPoint p) {
        return distance(p.getX(), p.getY());
    }

    // Method to calculate distance from this point to another specified x and y coordinates
    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    // Static method to calculate distance between two MyPoint objects
    public static double distance(MyPoint p1, MyPoint p2) {
        return p1.distance(p2);
    }

    // Main method to test the MyPoint class
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(10, 30.5);

        System.out.println("Distance between p1 and p2: " + MyPoint.distance(p1, p2));
    }
}