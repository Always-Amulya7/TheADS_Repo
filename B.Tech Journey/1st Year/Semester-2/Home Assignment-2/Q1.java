import java.util.*;
class Commission
{
    static double Sales;
    Commission(double Sales)
    {
        this.Sales=Sales;
    }
    double getCommission()
    {
        if (Sales<100)
        return (0.02*Sales);
        else if (Sales<5000)
        return ((0.02*Sales)+(0.05*(Sales-100)));
        else
        return ((0.02*Sales)+(0.05*(4500))+(0.08*(Sales-500)));
    }
}
class Q1
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Sales Of A User: ");
            double Sales=sc.nextDouble();
            Commission Com=new Commission(Sales);
            double Commission=Com.getCommission();
            if (Commission>0)
            System.out.println("Your Commission Is: "+Commission);
            else
            System.out.println("Invalid Input");
        }
    }
}