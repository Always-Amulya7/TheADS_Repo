import java.util.*;

class Point {
    private double X;
    private double Y;

    Point(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    void Copy(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    void set(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    void get() {
        System.out.println("The Value Of X And Y Is: (" + X + ", " + Y + ")");
    }
}

class Coordinate {
    public static void main(String args[]){
        try(Scanner Sc=new Scanner(System.in)){
            System.out.print("Enter X And Y Coordinate Values: ");
            double X=Sc.nextDouble();
            double Y=Sc.nextDouble();
            System.out.println("\nBy Using Parameterized Constructor");
            Point Coord1=new Point(X, Y);
            Coord1.get();
            Point Coord2=new Point(X,Y);
            System.out.println("By Using The Setter And Getter Method");
            Coord2.set(95.3, -5.4);
            Coord2.get();
            System.err.println("By Using The Copy Method To Retrieve");
            Coord2.Copy(X, Y);
            Coord2.get();
        }
    }
}