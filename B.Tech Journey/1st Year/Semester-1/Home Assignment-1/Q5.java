//With Extra Variable

/*class Q5
{
	public static void main(String args[])
	{
        int w = 10,g = 20,k = 30,a = 40;

        int temp;

        // Swapping the values of w and a
        temp = w;
        w = a;
        a = temp;

        // Swapping the values of a and k
        temp = a;
        a = k;
        k = temp;

        // Swapping the values of k and g
        temp = k;
        k = g;
        g = temp;

        // Swapping the values of g and w
        temp = g;
        g = w;
        w = temp;

        System.out.println("The new value of w is " + w);
        System.out.println("The new value of g is " + g);
        System.out.println("The new value of k is " + k);
        System.out.println("The new value of a is " + a);
    }
}*/

//Without Extra Variable

class Q5
{
    public static void main(String[] args)
    {
        int w = 10;
        int g = 20;
        int k = 30;
        int a = 40;

        // Swapping the values of w and a
        w = w + a; // w = 10 + 40 = 50
        a = w - a; // a = 50 - 40 = 10
        w = w - a; // w = 50 - 10 = 40

        // Swapping the values of a and k
        a += k; // a = 10 + 30 = 40
        k = a - k; // k = 40 - 30 = 10
        a -= k; // a = 40 - 10 = 30

        // Swapping the values of k and g
        k += g; // k = 10 + 20 = 30
        g = k - g; // g = 30 - 20 = 10
        k -= g; // k = 30 - 10 = 20

        // Swapping the values of g and w
        g += w; // g = 10 + 40 = 50
        w = g - w; // w = 50 - 40 = 10
        g -= w; // g = 50 - 10 = 40

        System.out.println("The new value of w is " + w);
        System.out.println("The new value of g is " + g);
        System.out.println("The new value of k is " + k);
        System.out.println("The new value of a is " + a);
    }
}