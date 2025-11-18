class Q6
{
    public static void main(String args[])
    {
        int Number=Integer.parseInt(args[0]);
        System.out.println("The Number Is: "+Number);
        System.out.print(Number+" Is Odd: "+isOdd(Number));
    }
    public static boolean isOdd(int n)
    {
        return (n & 1) == 1;
    }
}