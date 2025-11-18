class Q8
{
    public static void main(String[] args)
    {
        int x = 10;
        int y = 20;

        // Swapping the values of x and y without using an extra variable
        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("The new value of x is " + x);
        System.out.println("The new value of y is " + y);
    }
}