//The surface area of a cylinder can be defined as A= πr2+2πrh, where r and h are the radius height of the cylinder respectively. Write a java program to find the area where r and h are inputted from command line argument. Hint: Use Math.PI.

class Q2
{
public static void main(String[] args) 
{
double radius = Double.parseDouble(args[0]);
double height = Double.parseDouble(args[1]);
if (radius < 0 || height < 0) 
{
System.out.println("Invalid input: Radius and height must be positive.");
}
double surfaceArea = Math.PI * radius * radius + 2 * Math.PI * radius * height;
System.out.println("The surface area of a cylinder with radius " + radius + " and height " + height + " is: " + surfaceArea);
}
}