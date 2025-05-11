// Trent Moore, COP 3330C Object Oriented Programming, January 18, 2025
// This application demonstrates the use of classes and objects within Java Programming. The purpose of this code is to create two objects within the Chipotle, and Olive Garden
//classes. Once created these two object are then to be displayed with their details within the prompts, and then a update to the objects details are then updated by the program.

public class RestaurantApp {
    public static void main(String[] args) {
        // Instantiate Olive Garden
        OliveGarden oliveGarden = new OliveGarden(50, "Chicken Alfredo", 9.99); //This is the create the new object within the OliveGarden Class
        oliveGarden.printDetails(); //This is to print the details of the new OliveGarden Object
        oliveGarden.offerSoup(); // This is to print the OliveGarden Class compeny slogan

        // Update an attribute
        oliveGarden.setMenuSpecial("Seafood Alfredo"); // This is to update the OliveGrade class object menu special
        System.out.println("\nUpdated Olive Garden Details:"); // This is to print a log entry that the olivegarden object has been updated.
        oliveGarden.printDetails(); // Print the olive garden object details

        // Instantiate Raising Canes
        RaisingCanes RaisingCanes = new RaisingCanes("Chicken Sandwich", true, 4.50); // Create new canes object
        RaisingCanes.printDetails(); //Print details of new canes object to user
        RaisingCanes.OutputGreeting(); // Print sauce details to user

        // Update an attribute
        RaisingCanes.sethasCanesSauce(false); // Update canes has sauce flag within object.
        System.out.println("\nUpdated Canes Details:"); // Alert user of new update completed on object
        RaisingCanes.printDetails(); //Print canes object details
    }
}
