/* 
 Author: Ricky Duncan
SDEV200-11
08/08/2024
Assignment: Module 3 Programming Assignment 2
*/

public class GeometricObject implements Comparable<GeometricObject> {
    private String color = "white";
    private boolean filled;

    public GeometricObject() {
    }

    // Constructor with color and filled values
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Getter and setter methods for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Getter and setter methods for filled
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // toString method for GeometricObject
    @Override
    public String toString() {
        return "color: " + color + " and filled: " + filled;
    }

    // Implement the Comparable interface to compare objects based on area
    @Override
    public int compareTo(GeometricObject o) {
        if (this instanceof Triangle && o instanceof Triangle) {
            Triangle t1 = (Triangle) this;
            Triangle t2 = (Triangle) o;
            return Double.compare(t1.getArea(), t2.getArea());
        }
        return 0; // Add more logic if dealing with other shapes
    }

    // Static method to return the larger of two GeometricObjects based on area
    public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
        if (o1.compareTo(o2) > 0) {
            return o1;
        } else {
            return o2;
        }
    }
}

// Triangle class extending GeometricObject
public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    // Constructor with specified sides
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Accessor methods for side1, side2, and side3
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    // Method to calculate the area of the triangle using Heron's formula
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Method to calculate the perimeter of the triangle
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // toString method for Triangle
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}

public class TestGeometricObject {
    public static void main(String[] args) {
        // Create two Triangle objects
        Triangle triangle1 = new Triangle(3, 4, 5);
        Triangle triangle2 = new Triangle(6, 8, 10);

        // Set colors and filled status
        triangle1.setColor("blue");
        triangle1.setFilled(true);

        triangle2.setColor("red");
        triangle2.setFilled(false);

        // Display areas and perimeters
        System.out.println("Triangle 1 - Area: " + triangle1.getArea() + ", Perimeter: " + triangle1.getPerimeter());
        System.out.println("Triangle 2 - Area: " + triangle2.getArea() + ", Perimeter: " + triangle2.getPerimeter());

        // Find the larger triangle
        GeometricObject largerTriangle = GeometricObject.max(triangle1, triangle2);
        System.out.println("The larger triangle is: " + largerTriangle);
    }
}