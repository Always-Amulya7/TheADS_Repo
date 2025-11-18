import java.util.*;

class Main {
    private double Length;
    private double Width;

    Main(double Length, double Width) {
        this.Length = Length;
        this.Width = Width;
        System.out.println("The Rectangle Calculations: ");
    }

    void set(double Length, double Width) {
        this.Length = Length;
        this.Width = Width;
    }

    void get(){
        System.out.println("The Area Of Rectangle Is: "+Area(Length,Width));
        System.out.println("The Perimeter Of Rectangle Is: "+Perimeter(Length,Width));
    }

    double Area(double Length,double Width){
        return Length*Width;
    }

    double Perimeter(double Length,double Width){
        return 2*(Length+Width);
    }
}

class Calculations {
    public static void main(String args[]) {
        Main Calculate = new Main(5.5, 9.5);
        System.out.println("By Parameterized Calling\n");
        Calculate.get();
        System.out.println("By Setter And Getter Method\n");
        Calculate.set(9.5, 5.5);
        Calculate.get();
    }
}