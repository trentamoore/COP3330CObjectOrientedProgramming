// Trent Moore, COP 3330C Object Oriented Programming, January 18, 2025
// This application demonstrates the use of classes and objects within Java Programming. The purpose of this code is to create two objects within the Chipotle, and Olive Garden
//classes. Once created these two object are then to be displayed with their details within the prompts, and then a update to the objects details are then updated by the program.
//This class is intended to the creation and modification of objects within the Raising Canes.
public class RaisingCanes {
    private String MealType;
    private boolean hasCanesSauce;
    private double SweetTeaPrice;

    // Constructor - This is utilized within the creation of the objects within this class.
    public RaisingCanes(String MealType, boolean hasCanesSauce, double SweetTeaPrice) {
        this.MealType = MealType;
        this.hasCanesSauce = hasCanesSauce;
        this.SweetTeaPrice = SweetTeaPrice;
    }

    // Overloaded constructor
    public RaisingCanes() {
        this(null, false, 0.0);
    }

    // Getters and Setters
    public String getMealType() {
        return MealType;
    }

    public void setMealType(String mealType) {
        this.MealType = getMealType();
    }

    public boolean ishasCanesSauce() {
        return hasCanesSauce;
    }

    public void sethasCanesSauce(boolean hasCanesSauce) {
        this.hasCanesSauce = hasCanesSauce;
    }

    public double getSweetTeaPrice() {
        return SweetTeaPrice;
    }

    public void setSweetTeaPrice(double sweetTeaPrice) {
        this.SweetTeaPrice = SweetTeaPrice;
    }

    // Custom Method - This is utilized for a custom greeting
    public void OutputGreeting() {
        System.out.println("Hot Chicken, Hot Chicken, What Combo you Pickin");

    }

    // Print Method - This is utilized for the printing of the objects details to the user.
    public void printDetails() {
        System.out.println("Canes Details:");
        System.out.println("Meal Type: " + MealType);
        System.out.println("Canes Sauce Y/N: " + hasCanesSauce);
        System.out.println("Sweet Tea Price: $" + SweetTeaPrice);
    }
}
