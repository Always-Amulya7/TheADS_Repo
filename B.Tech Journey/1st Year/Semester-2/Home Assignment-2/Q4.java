class Distance 
{
    private int meters;
    private int centimeters;

    // Parameterized constructor
    public Distance(int meters, int centimeters) 
    {
        this.meters = meters;
        this.centimeters = centimeters;
    }

    // Display method to display the distance
    public void display() 
    {
        System.out.println("Distance: " + meters + " meters " + centimeters + " centimeters");
    }

    // Method to add two distances
    public void sum(Distance d1, Distance d2)
    {
        int totalCentimeters = d1.centimeters + d2.centimeters;
        int carry = totalCentimeters / 100; // Find carry if centimeters exceed 100
        int remainingCentimeters = totalCentimeters % 100;
        int totalMeters = d1.meters + d2.meters + carry;
        System.out.println("Sum of distances:");
        System.out.println("Total Meters: " + totalMeters + " meters");
        System.out.println("Total Centimeters: " + remainingCentimeters + " centimeters");
    }
}

public class Q4
{
    public static void main(String[] args)
    {
        // Creating Distance objects
        Distance distance1 = new Distance(5, 70); // 5 meters 70 centimeters
        Distance distance2 = new Distance(3, 30); // 3 meters 30 centimeters

        // Displaying distances
        System.out.println("Distance 1:");
        distance1.display();
        System.out.println();

        System.out.println("Distance 2:");
        distance2.display();
        System.out.println();

        // Adding distances
        Distance totalDistance = new Distance(0, 0);
        totalDistance.sum(distance1, distance2);
    }
}