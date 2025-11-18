import java.util.Scanner;
class Q4
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Word: ");
            String Str=sc.next();
            char[] Store=Str.toCharArray();
            for (int i=0;i<Store.length;i++)
            {
                for (int j=0;j<Store.length;j++)
                {
                    for (int k=0;k<Store.length;k++)
                    {
                        if (i!=j && i!=k && j!=k)
                        System.out.println(""+Store[i]+Store[j]+Store[k]);
                    }
                }
            }
        }
    }
}