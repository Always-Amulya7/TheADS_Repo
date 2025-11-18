class Complex
{
    double real;
    double imag;
    public void setData(double real, double imag)
    {
        this.real = real;
        this.imag = imag;
    }
    public void display()
    {
        System.out.println(real + " + " + imag + "i");
    }
    public Complex add(Complex num1, Complex num2)
    {
        Complex result = new Complex();
        result.real = num1.real + num2.real;
        result.imag = num1.imag + num2.imag;
        return result;
    }
}
public class Q2
{
    public static void main(String[] args)
    {
        Complex num1 = new Complex();
        Complex num2 = new Complex();

        num1.setData(3.5, 2.0);
        num2.setData(1.5, 4.5);

        Complex sum = num1.add(num1, num2);

        System.out.println("First complex number:");
        num1.display();
        System.out.println("Second complex number:");
        num2.display();
        System.out.println("Sum of the complex numbers:");
        sum.display();
    }
}
