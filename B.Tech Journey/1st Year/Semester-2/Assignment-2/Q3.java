class Product
{
    private int prodId;
    private double price;
    private int quantity;
    private static double totalPrice = 0;
    public Product(int prodId, double price, int quantity)
    {
        this.prodId = prodId;
        this.price = price;
        this.quantity = quantity;
        totalPrice += price * quantity;
    }
    public void display()
    {
        System.out.println("Product ID: " + prodId);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("-------------------------");
    }
    public static double getTotalPrice() 
    {
        return totalPrice;
    }
}
public class Q3 
{
    public static void main(String[] args)
    {
        /*Product product1 = new Product(1, 10.5, 2);
        Product product2 = new Product(2, 20.75, 3);
        Product product3 = new Product(3, 15.0, 1);
        Product product4 = new Product(4, 8.25, 4);
        Product product5 = new Product(5, 12.0, 2);
        System.out.println("Details of Purchased Products:");
        product1.display();
        product2.display();
        product3.display();
        product4.display();
        product5.display();*/
        Product[] Arr=new Product[5];
        Arr[0]=new Product(1, 10.5, 2);
        Arr[1]=new Product(2, 20.75, 3);
        Arr[2]=new Product(3, 15.0, 1);
        Arr[3]=new Product(4, 8.25, 4);
        Arr[4]=new Product(5, 12.0, 2);
        for (int i=0;i<Arr.length;i++)
        {
            Arr[i].display();
        }
        System.out.println("Total Amount to be paid: $" + Product.getTotalPrice());
    }
}