import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) {
        // Correct SQLite JDBC URL
        String url = "jdbc:sqlite:/Users/trentmoore/University.db";

        try (Connection connection = DriverManager.getConnection(url)) {
            if (connection != null) {
                System.out.println("Connection to SQLite database established successfully!");

                // Execute query: SELECT * FROM engineeringstudents
                String query = "SELECT * FROM engineeringstudents";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                // Print results from the "engineeringstudents" table with all columns
                while (resultSet.next()) {
                    System.out.println(
                            resultSet.getInt("Student_ID") + " | " +
                                    resultSet.getString("Department") + " | " +
                                    resultSet.getString("First_Name") + " | " +
                                    resultSet.getString("Last_Name") + " | " +
                                    resultSet.getInt("PassOutYear") + " | " +
                                    resultSet.getInt("UniversityRank")
                    );
                }

                // Close resources
                resultSet.close();
                statement.close();
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}