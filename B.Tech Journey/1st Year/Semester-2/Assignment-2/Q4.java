class Deposit
{
    private Long Principal;
    private int Time;
    private double Rate,TotalAmt;
    Deposit()
    {
        System.out.println("Enter To Initialize: ");
    }
    Deposit (long P, int T, double R)
    {
        this.Principal=P;
        this.Time=T;
        this.Rate=R;
    }
    Deposit (long P, int T)
    {
        this.Principal=P;
        this.Time=T;
    }
    Deposit (long P, double R)
    {
        this.Principal=P;
        this.Rate=R;
    }
    void Display()
    {
        System.out.println("Principal="+Principal);
        System.out.println("Rate="+Rate);
        System.out.println("Time="+Time);
    }
    public double calcAmt()
    {
        TotalAmt=(Principal+(Principal*Rate*Time)/100);
        return TotalAmt;
    }
}
public class Q4
{
    public static void main(String args[])
    {
        Deposit Ob1 = new Deposit(5000L, 2, 5.0);
        Deposit Ob2 = new Deposit(5000, 2);
        Deposit Ob3 = new Deposit(5000, 5);
        Ob1.Display();
        System.out.println("Total Amount 1: " + Ob1.calcAmt());
        Ob2.Display();
        System.out.println("Total Amount 2: " + Ob2.calcAmt());
        Ob3.Display();
        System.out.println("Total Amount 3: " + Ob3.calcAmt());
    }
}