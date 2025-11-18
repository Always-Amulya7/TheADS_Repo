import java.util.*;
class Bank
{
    private String bankName;
    private double depositAmount;
    private static double totalAmount = 0;
    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }
    public void setAmount(double depositAmount)
    {
        if (depositAmount >= 1000)
        {
            this.depositAmount = depositAmount;
            totalAmount += depositAmount;
        } 
        else
        {
            System.out.println("Minimum deposit amount is 1000.");
        }
    }
    public void showData()
    {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Deposit Amount: " + depositAmount);
    }
    public static double getTotalAmount()
    {
        return totalAmount;
    }
    public static String getMinimumDepositBank(Bank[] banks)
    {
        double minDeposit = Double.MAX_VALUE;
        String bankName = "";
        for (Bank bank : banks)
        {
            if (bank.depositAmount < minDeposit)
            {
                minDeposit = bank.depositAmount;
                bankName = bank.bankName;
            }
        }
        return bankName;
    }
}
public class Q3
{
    public static void main(String[] args)
    {
        Bank[] banks = new Bank[5];
        banks[0] = new Bank();
        banks[0].setBankName("Bank A");
        banks[0].setAmount(1500);

        banks[1] = new Bank();
        banks[1].setBankName("Bank B");
        banks[1].setAmount(2000);

        banks[2] = new Bank();
        banks[2].setBankName("Bank C");
        banks[2].setAmount(1200);

        banks[3] = new Bank();
        banks[3].setBankName("Bank D");
        banks[3].setAmount(950);

        banks[4] = new Bank();
        banks[4].setBankName("Bank E");
        banks[4].setAmount(1800);

        // Display bank information
        System.out.println("Bank Information:");
        for (Bank bank : banks) 
        {
            bank.showData();
            System.out.println();
        }

        // Display total amount deposited
        System.out.println("Total Amount Deposited: " + Bank.getTotalAmount());

        // Display bank with minimum deposit amount
        System.out.println("Bank with Minimum Deposit: " + Bank.getMinimumDepositBank(banks));
    }
}