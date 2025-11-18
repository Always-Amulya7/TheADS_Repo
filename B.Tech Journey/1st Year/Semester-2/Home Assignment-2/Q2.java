import java.util.*;
class Book
{
    String BName, BEdition;
    double BPrice;
    Book(String BName, String BEdition, double BPrice)
    {
        this.BName = BName;
        this.BEdition = BEdition;
        this.BPrice = BPrice;
    }
}

public class Q2
{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            Book[] books = new Book[5];
            books[0] = new Book("Harry Potter", "Deathly Hallows", 995);
            books[1] = new Book("Geronimo Stilton", "Elisabetta Dami", 495);
            books[2] = new Book("Oliver Twist", "Charles Dickens", 545);
            books[3] = new Book("Malgudi Day", "RK Narayan", 125);
            books[4] = new Book("Wings Of Fire", "APJ Abdul Kalam", 675);

            double maxPrice = books[0].BPrice;
            int maxIndex = 0;

            for (int i = 1; i < books.length; i++) 
            {
                if (books[i].BPrice > maxPrice) 
                {
                    maxPrice = books[i].BPrice;
                    maxIndex = i;
                }
            }

            System.out.println("Book with maximum price:");
            System.out.println("Book Name: " + books[maxIndex].BName);
            System.out.println("Book Edition: " + books[maxIndex].BEdition);
            System.out.println("Book Price: " + books[maxIndex].BPrice);
        }
    }
}