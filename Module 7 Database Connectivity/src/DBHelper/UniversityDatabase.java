// Name: Trent Moore
// Purpose: To demonstrate database connectivity within Java programming with the use of SQLite
// Description: This main class simulates user input to create, delete, and modify database records with output after each action.

package DBHelper;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class UniversityDatabase {
    public static void main(String[] args) {
        // Create instance of database helper class
        engineeringstudents db = new engineeringstudents();

        // Create and insert first student record
        db.insert(1, "Computer Science", "Alice", "Smith", 2022, 5);
        System.out.println("Inserted record: Student_ID = 1");

        // Create and insert second student record
        db.insert(2, "Electrical Engineering", "Bob", "Johnson", 2023, 8);
        System.out.println("Inserted record: Student_ID = 2");

        // Query and print all records
        ArrayList<ArrayList<Object>> data = db.getExecuteResult("SELECT * FROM engineeringstudents;");
        for (List<Object> record : data) {
            System.out.println(record.toString());
        }

        // Delete two specific records
        db.delete("Student_ID", "10213");
        db.delete("Student_ID", "10214");
        System.out.println("Deleted Student_ID 10213 and 10214");

        // Query and print all records after deletion
        data = db.getExecuteResult("SELECT * FROM engineeringstudents;");
        System.out.println("Database contents after deletion:");
        printDatabaseContents(data);

        // Query and print records with PassOutYear = 2025
        data = db.getExecuteResult("SELECT * FROM engineeringstudents WHERE passoutyear = 2025;");
        System.out.println("Database contents after specific query:");
        printDatabaseContents(data);

        // Update PassOutYear for Student_IDs 1, 2, and 468547
        db.update(engineeringstudents.PassOutYear, "2026", engineeringstudents.Student_ID, "1");
        System.out.println("Updated PassOutYear for Student_ID = 1");

        db.update(engineeringstudents.PassOutYear, "2026", engineeringstudents.Student_ID, "2");
        System.out.println("Updated PassOutYear for Student_ID = 2");

        db.update(engineeringstudents.PassOutYear, "2026", engineeringstudents.Student_ID, "468547");
        System.out.println("Updated PassOutYear for Student_ID = 468547");

        // Display final table using DefaultTableModel
        DefaultTableModel table = db.selectToTable("*", null, null, null, null);
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                System.out.print(table.getValueAt(i, j).toString() + " ");
            }
            System.out.println();
        }
    }

    // Utility method to print 2D list of database records
    public static void printDatabaseContents(ArrayList<ArrayList<Object>> data) {
        for (List<Object> record : data) {
            System.out.println(record.toString());
        }
    }
}