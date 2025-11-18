//From the above question no. (6) write a java program with a 
//choice if the consumer wants to pay bill online. Consumer who pays 
//their electricity bill online will get a discount of 3%.

//Here is the sample output:
///No. of units consumed: 867
//Do you want to pay online(y/n): y
//Total amount: 4925.4
//Discount: 147.762
//Amount payable: 4777.638

import java.util.*;
public class Q7
{
public static void main(String[] args)
{
try(Scanner sc = new Scanner (System.in))
{
	System.out.println("Enter the unit: ");
    int unit = sc.nextInt();
    System.out.println("Do you want to pay online(y/n):");
    char c = sc.next().charAt(0);
    System.out.println("No. of units consumed: "+unit);
    double amount= 0;
    double discount = 0.0;
    if (unit <=50)
    {
        amount= unit *3;
    }
    else if (unit <=200)
    {
       amount=50*3+(unit -50)*4.80;
    }
    else if(unit <=400)
    {
       amount=50*3+150*4.80+(unit -200)*5.80;
    }
    else
    {
       amount=50*3+150*4.80+200*5.80+(unit -400)*6.20;
    }
    if (c=='y')
    {
       discount = amount*0.03;
    }
    System.out.println("Total amount is "+amount);
    System.out.println("Discount:"+discount);
    System.out.println("Amount payable: "+(amount-discount));
}
}
}