// Import Scanner class to read user input from the console
import java.util.Scanner;

// Define an interface that all golf clubs will implement
interface GolfClub {
    void swing(); // Each club will have a unique way of swinging
    void adjust(Scanner scanner); // Clubs can be adjusted based on user input
}

// Base class representing a generic golf club
class Club implements GolfClub {
    protected String name; // Name of the club (e.g., Driver, Putter)
    protected int loft; // Loft angle of the club in degrees (affects ball trajectory)
    protected double length; // Length of the club in inches

    // Constructor to initialize a club with its name, loft, and length
    public Club(String name, int loft, double length) {
        this.name = name;
        this.loft = loft;
        this.length = length;
    }

    // Getter methods to retrieve club properties
    public String getName() { return name; }
    public int getLoft() { return loft; }
    public double getLength() { return length; }

    // Setter methods to update loft and length of the club
    public void setLoft(int loft) { this.loft = loft; }
    public void setLength(double length) { this.length = length; }

    // Default swing method - prints a basic message when swung
    public void swing() {
        System.out.println(name + " is being swung...");
    }

    // Allow user to adjust the club's loft and length
    public void adjust(Scanner scanner) {
        System.out.println("Adjusting " + name + " settings...");

        // Ask user for a new loft angle (optional)
        System.out.print("Enter new loft angle (current: " + loft + ") or press Enter to keep: ");
        String input = scanner.nextLine();
        if (!input.isEmpty()) loft = Integer.parseInt(input); // Update if user provides a value

        // Ask user for a new length (optional)
        System.out.print("Enter new length (current: " + length + ") or press Enter to keep: ");
        input = scanner.nextLine();
        if (!input.isEmpty()) length = Double.parseDouble(input); // Update if user provides a value
    }

    // Convert club details into a readable string format
    @Override
    public String toString() {
        return "Club: " + name + ", Loft: " + loft + " degrees, Length: " + length + " inches";
    }
}

// Subclass for Driver clubs (inherits from Club)
class Driver extends Club {
    private int shaftFlex; // Flexibility rating of the shaft

    // Constructor to create a Driver with specific loft, length, and shaft flex
    public Driver(int loft, double length, int shaftFlex) {
        super("Driver", loft, length); // Calls Club constructor with name "Driver"
        this.shaftFlex = shaftFlex;
    }

    // Override the swing method for Drivers
    @Override
    public void swing() {
        System.out.println("Swinging the Driver for maximum distance!");
    }

    // Allow user to adjust Driver-specific settings (like shaft flex)
    @Override
    public void adjust(Scanner scanner) {
        super.adjust(scanner); // Call the parent class's adjust method first

        // Ask user for a new shaft flex rating (optional)
        System.out.print("Enter new shaft flex rating (current: " + shaftFlex + ") or press Enter to keep: ");
        String input = scanner.nextLine();
        if (!input.isEmpty()) shaftFlex = Integer.parseInt(input); // Update if user provides a value
    }

    // Convert Driver details into a readable string format
    @Override
    public String toString() {
        return super.toString() + ", Shaft Flex: " + shaftFlex;
    }
}

// Subclass for Putter clubs (inherits from Club)
class Putter extends Club {
    private String gripType; // Type of grip used on the putter

    // Constructor to create a Putter with specific length and grip type
    public Putter(double length, String gripType) {
        super("Putter", 3, length); // Calls Club constructor with a default loft of 3 degrees
        this.gripType = gripType;
    }

    // Override the swing method for Putters
    @Override
    public void swing() {
        System.out.println("Making a smooth putting stroke with the Putter!");
    }

    // Allow user to adjust Putter-specific settings (like grip type)
    @Override
    public void adjust(Scanner scanner) {
        super.adjust(scanner); // Call the parent class's adjust method first

        // Ask user for a new grip type (optional)
        System.out.print("Enter new grip type (current: " + gripType + ") or press Enter to keep: ");
        String input = scanner.nextLine();
        if (!input.isEmpty()) gripType = input; // Update if user provides a value
    }

    // Convert Putter details into a readable string format
    @Override
    public String toString() {
        return super.toString() + ", Grip Type: " + gripType;
    }
}

// Main class containing the execution logic for the program
public class GolfGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner object to read user input

        // Create an array of golf clubs (Driver and Putter instances)
        Club[] bag = new Club[5];
        bag[0] = new Driver(10, 45.5, 60);  // A Driver with loft 10, length 45.5 inches, shaft flex 60
        bag[1] = new Driver(9, 46, 70);     // A Driver with loft 9, length 46 inches, shaft flex 70
        bag[2] = new Putter(34, "Standard");  // A Putter with length 34 inches, Standard grip
        bag[3] = new Putter(35, "Midsize");   // A Putter with length 35 inches, Midsize grip
        bag[4] = new Putter(33, "Oversized"); // A Putter with length 33 inches, Oversized grip

        // Display all clubs in the golf bag
        System.out.println("Welcome to the Golf Course! Here is your golf bag:");
        for (int i = 0; i < bag.length; i++) {
            System.out.println(i + ": " + bag[i]); // Print each club with its index
        }

        // Ask the user to select a club to adjust
        System.out.print("\nChoose a club to adjust (0-4): ");
        int choice = scanner.nextInt(); // Read user input (which club to modify)
        scanner.nextLine(); // Consume the leftover newline character

        // Check if the user entered a valid index (0-4)
        if (choice >= 0 && choice < bag.length) {
            bag[choice].swing(); // Perform a swing action with the selected club
            bag[choice].adjust(scanner); // Allow user to adjust settings
            System.out.println("Updated: " + bag[choice]); // Display updated club details
        } else {
            System.out.println("Invalid choice!"); // Handle invalid input
        }

        // Close the scanner
        scanner.close();
    }
}