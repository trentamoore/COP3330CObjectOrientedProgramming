// Trent Moore, COP 3330C Object Oriented Programming, January 18, 2025
// This application demonstrates the use of classes and objects within Java Programming. The purpose of this code is to create two objects within the Chipotle, and Olive Garden
//classes. Once created these two object are then to be displayed with their details within the prompts, and then a update to the objects details are then updated by the program.
//This class is intended to the creation and modification of objects within the Olive Garden Class.
public class OliveGarden {
    private int customerCount;
    private String menuSpecial;
    private double soupPrice;

    // Constructor
    public OliveGarden(int customerCount, String menuSpecial, double soupPrice) {
        this.customerCount = customerCount;
        this.menuSpecial = menuSpecial;
        this.soupPrice = soupPrice;
    }

    // Overloaded constructor
    public OliveGarden() {
        this(0, null, 0.0);
    }

    // Getters and Setters
    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

    public String getMenuSpecial() {
        return menuSpecial;
    }

    public void setMenuSpecial(String menuSpecial) {
        this.menuSpecial = menuSpecial;
    }

    public double getSoupPrice() {
        return soupPrice;
    }

    public void setSoupPrice(double soupPrice) {
        this.soupPrice = soupPrice;
    }

    // Custom Method
    public void offerSoup() {
        System.out.println("Try our unlimited soup, salad, and breadsticks for only $" + soupPrice + "!");
    }

    // Print Method
    public void printDetails() {
        System.out.println("Olive Garden Details:");
        System.out.println("Customer Count: " + customerCount);
        System.out.println("Menu Special: " + menuSpecial);
        System.out.println("Soup Price: $" + soupPrice);
    }
}
