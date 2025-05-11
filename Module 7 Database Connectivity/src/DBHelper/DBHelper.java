package DBHelper; // Declare the package for the DBHelper class

import javax.swing.table.DefaultTableModel; // Import DefaultTableModel for GUI table representations
import java.sql.*; // Import SQL classes for database connectivity and operations
import java.util.ArrayList; // Import ArrayList for dynamic list handling

public class DBHelper {
	// Constant for the SQLite database file path
	private final String DATABASE_NAME = "//Users/trentmoore/University.db";
	// Database connection object
	private Connection connection;
	// SQL statement object used to execute queries
	private Statement statement;
	// ResultSet to hold query results
	private ResultSet resultSet;

	// Constructor initializes connection, statement, and resultSet to null
	public DBHelper() {
		connection = null;
		statement = null;
		resultSet = null;
	}

	// Private method to establish a connection to the SQLite database
	private void connect() {
		try {
			// Load the SQLite JDBC driver class into memory
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// Print the stack trace if the driver class is not found
			e.printStackTrace();
		}
		try {
			// Create a connection to the database using the database name
			connection = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_NAME);
			// Create a Statement object from the connection to execute SQL queries
			statement = connection.createStatement();
		} catch (SQLException e) {
			// Print the stack trace if a SQL error occurs during connection setup
			e.printStackTrace();
		}
	}

	// Private method to close the database connection, statement, and resultSet
	private void close() {
		try {
			// Close the database connection
			connection.close();
			// Close the SQL statement
			statement.close();
			// Close the resultSet if it's not null
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			// Print the stack trace if an error occurs while closing resources
			e.printStackTrace();
		}
	}

	// Private method to convert an ArrayList of ArrayLists into a 2D Object array
	private Object[][] arrayListTo2DArray(ArrayList<ArrayList<Object>> list) {
		Object[][] array = new Object[list.size()][];
		// Loop through the outer ArrayList
		for (int i = 0; i < list.size(); i++) {
			// Get each row (an inner ArrayList)
			ArrayList<Object> row = list.get(i);
			// Convert the row into an Object array and assign it to the 2D array
			array[i] = row.toArray(new Object[row.size()]);
		}
		// Return the 2D array for use in table models
		return array;
	}

	// Protected method to execute an SQL command that doesn't return data (e.g., INSERT, UPDATE, DELETE)
	protected void execute(String sql) {
		try {
			// Establish a connection to the database
			connect();
			// Execute the given SQL command
			statement.execute(sql);
		} catch (SQLException e) {
			// Print the stack trace if a SQL error occurs during execution
			e.printStackTrace();
		} finally {
			// Always close the connection and related resources
			close();
		}
	}

	// Protected method to execute a SELECT query and return the results as a DefaultTableModel
	protected DefaultTableModel executeQueryToTable(String sql) {
		// Create an ArrayList to hold the query result rows
		ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
		// Create an ArrayList to hold the column names
		ArrayList<Object> columns = new ArrayList<Object>();
		// Establish a connection to the database
		connect();
		try {
			// Execute the query and store the result in resultSet
			resultSet = statement.executeQuery(sql);
			// Get the number of columns from the resultSet metadata
			int columnCount = resultSet.getMetaData().getColumnCount();
			// Loop through each column to get its name and add to the columns list
			for (int i = 1; i <= columnCount; i++)
				columns.add(resultSet.getMetaData().getColumnName(i));
			// Loop through each row in the resultSet
			while (resultSet.next()) {
				ArrayList<Object> subresult = new ArrayList<Object>();
				// Loop through each column in the current row and add its value to the subresult list
				for (int i = 1; i <= columnCount; i++)
					subresult.add(resultSet.getObject(i));
				// Add the current row to the result list
				result.add(subresult);
			}
		} catch (SQLException e) {
			// Print the stack trace if a SQL error occurs during the query
			e.printStackTrace();
		}
		// Close the database connection and related resources
		close();
		// Return a new DefaultTableModel using the 2D array representation of results and the columns array
		return new DefaultTableModel(arrayListTo2DArray(result), columns.toArray());
	}

	// Protected method to execute a SELECT query and return the results as a nested ArrayList
	protected ArrayList<ArrayList<Object>> executeQuery(String sql) {
		// Create an ArrayList to hold the query result rows
		ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
		// Establish a connection to the database
		connect();
		try {
			// Execute the query and store the result in resultSet
			resultSet = statement.executeQuery(sql);
			// Get the number of columns from the resultSet metadata
			int columnCount = resultSet.getMetaData().getColumnCount();
			// Loop through each row in the resultSet
			while (resultSet.next()) {
				ArrayList<Object> subresult = new ArrayList<Object>();
				// Loop through each column in the current row
				for (int i = 1; i <= columnCount; i++) {
					// Add the column value to the subresult list
					subresult.add(resultSet.getObject(i));
				}
				// Add the row to the result list
				result.add(subresult);
			}
		} catch (SQLException e) {
			// Print the stack trace if a SQL error occurs during query execution
			e.printStackTrace();
		}
		// Close the database connection and related resources
		close();
		// Return the query result as a nested ArrayList
		return result;
	}
}