import java.util.*;

class ImageLibrary {
    Scanner sc = new Scanner(System.in);
    Vector<Image> store = new Vector<>();
    ImageLibrary() {
        System.out.println("Welcome To Image Library");
        String choice = "";
        while (true) {
            System.out.println("Do you want to add an image (Yes/No)?");
            choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("Yes")) {
                break;
            }
            System.err.println("Enter The Image Properties: ");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            sc.nextLine();
            String color = sc.nextLine();
            Image obj = new Image(x, y, color);
            store.add(obj);
        }
        System.out.println("Exit Image Library.");
    }
    

    boolean search(double x, double y, String color) {
        for (Image img : store) {
            if (img.getImageWidth() == x && img.getImageHeight() == y && img.getColorCode().equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }

    void insert(double x, double y, String color) {
        Image img = new Image(x, y, color);
        store.add(img);
        System.out.println("Image Inserted Successfully.");
    }

    void getImag(double x, double y, String color) {
        for (Image img : store) {
            if (img.getImageWidth() == x && img.getImageHeight() == y && img.getColorCode().equalsIgnoreCase(color)) {
                System.out.println("Image Found: " + img);
                return;
            }
        }
        System.out.println("Image Not Found.");
    }
}

public class ImageController {
    public static void main(String[] args) {
        ImageLibrary main = new ImageLibrary();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter The Characteristics: ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        sc.nextLine();
        String color = sc.nextLine();
        System.out.println("The Search Was Successful? " + main.search(x, y, color));
        
        System.out.println("Perform Insertion? ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        sc.nextLine();
        String color1 = sc.nextLine();
        main.insert(x1, y1, color1);
        
        System.out.println("Need The Image? ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        sc.nextLine();
        String color2 = sc.nextLine();
        main.getImag(x2, y2, color2);
        sc.close();
    }
}