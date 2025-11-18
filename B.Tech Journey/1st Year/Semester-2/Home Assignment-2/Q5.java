class PointType
{
    private double x;
    private double y;

    // Parameterized constructor
    public PointType(double x, double y) 
    {
        this.x = x;
        this.y = y;
    }

    // Setter methods
    public void setX(double x) 
    {
        this.x = x;
    }

    public void setY(double y) 
    {
        this.y = y;
    }

    // Getter methods
    public double getX() 
    {
        return x;
    }

    public double getY() 
    {
        return y;
    }

    // Display method to print coordinates
    public void display() 
    {
        System.out.println("Point Coordinates: (" + x + ", " + y + ")");
    }
}

class CircleType extends PointType 
{
    private double radius;

    // Parameterized constructor
    public CircleType(double x, double y, double radius)
    {
        super(x, y);
        this.radius = radius;
    }

    // Setter method for radius
    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    // Getter method for radius
    public double getRadius()
    {
        return radius;
    }

    // Calculate and print area of the circle
    public void calculateAndPrintArea()
    {
        double area = Math.PI * radius * radius;
        System.out.println("Area of the circle: " + area);
    }

    // Calculate and print circumference of the circle
    public void calculateAndPrintCircumference()
    {
        double circumference = 2 * Math.PI * radius;
        System.out.println("Circumference of the circle: " + circumference);
    }
}

public class Q5
{
    public static void main(String[] args)
    {
        // Creating a PointType object representing the center of the circle
        PointType center = new PointType(3, 4);

        // Creating a CircleType object
        CircleType circle = new CircleType(center.getX(), center.getY(), 5);

        // Displaying center coordinates
        center.display();

        // Displaying radius of the circle
        System.out.println("Radius of the circle: " + circle.getRadius());

        // Calculating and printing area of the circle
        circle.calculateAndPrintArea();

        // Calculating and printing circumference of the circle
        circle.calculateAndPrintCircumference();
    }
}