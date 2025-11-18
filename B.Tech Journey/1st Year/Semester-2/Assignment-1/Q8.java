import java.util.Scanner;
class Q8
{
    public static void main(String args[])
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter The Number Of Rows Of The Array: ");
            int Rows=sc.nextInt();
            System.out.print("Enter The Number Of Columns Of The Array: ");
            int Column=sc.nextInt();
            int Array[][],RowSum[],ColSum[];
            Array=new int[Rows][Column];
            RowSum=new int[Rows];
            ColSum=new int[Column];
            for (int i=0;i<Rows;i++)
            {
                for (int j=0;j<Column;j++)
                {
                    System.out.print("Enter The Element At Position "+(i+1)+""+(j+1)+" : ");
                    Array[i][j]=sc.nextInt();
                }
            }
            for (int i=0;i<Rows;i++)
            {
                RowSum[i]=0;
            }
            for (int j=0;j<Column;j++)
            {
                ColSum[j]=0;
            }
            for (int i=0;i<Rows;i++)
            {
                for (int j=0;j<Column;j++)
                {
                    RowSum[i]+=Array[i][j];
                }
            }
            for (int i=0;i<Column;i++)
            {
                for (int j=0;j<Rows;j++)
                {
                    ColSum[i]+=Array[i][j];
                }
            }
            int Sum=0;
            for (int i=0;i<Rows;i++)
            {
                Sum+=RowSum[i];
            }
            System.out.print("The Sum Of Elements Of The 2D-Array Is "+(Sum));
        }
    }
}