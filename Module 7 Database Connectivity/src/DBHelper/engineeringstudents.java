package DBHelper; // Declare the package where this class belongs

import javax.swing.table.DefaultTableModel; // Import DefaultTableModel for converting query results to a GUI table model
import java.util.ArrayList; // Import ArrayList for storing and returning query results

// Define the engineeringstudents class which extends DBHelper to inherit database helper methods
public class engineeringstudents extends DBHelper {
	// Constant representing the table name in the database
	private final String TABLE_NAME = "engineeringstudents";

	// Public constants for each column name in the table
	public static final String Student_ID = "Student_ID";
	public static final String Department = "Department";
	public static final String First_Name = "First_Name";
	public static final String Last_Name = "Last_Name";
	public static final String PassOutYear = "PassOutYear";
	public static final String UniversityRank = "UniversityRank";

	// Private method to construct an SQL SELECT query with optional filtering and sorting
	private String prepareSQL(String fields, String whatField, String whatValue, String sortField, String sort) {
		String query = "SELECT "; // Begin the SELECT statement
		// If no specific fields are provided, select all columns; otherwise, select the given fields
		query += fields == null ? " * FROM " + TABLE_NAME : fields + " FROM " + TABLE_NAME;
		// If filtering parameters are provided, add a WHERE clause to the query
		query += whatField != null && whatValue != null ? " WHERE " + whatField + " = \"" + whatValue + "\"" : "";
		// If sorting parameters are provided, add an ORDER BY clause to the query
		query += sort != null && sortField != null ? " order by " + sortField + " " + sort : "";
		return query; // Return the fully constructed SQL query
	}

	// Method to insert a new record into the engineeringstudents table
	public void insert(Integer Student_ID, String Department, String First_Name, String Last_Name, Integer PassOutYear, Integer UniversityRank) {
		// Wrap string values in quotes if they are not null
		Department = Department != null ? "\"" + Department + "\"" : null;
		First_Name = First_Name != null ? "\"" + First_Name + "\"" : null;
		Last_Name = Last_Name != null ? "\"" + Last_Name + "\"" : null;

		// Arrays holding the values and corresponding field names for the insert operation
		Object[] values_ar = {Student_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank};
		String[] fields_ar = {engineeringstudents.Student_ID, engineeringstudents.Department, engineeringstudents.First_Name, engineeringstudents.Last_Name, engineeringstudents.PassOutYear, engineeringstudents.UniversityRank};
		String values = "", fields = "";
		// Loop over the arrays to build comma-separated lists of values and field names
		for (int i = 0; i < values_ar.length; i++) {
			if (values_ar[i] != null) {
				values += values_ar[i] + ", "; // Append the value and a comma
				fields += fields_ar[i] + ", ";  // Append the field name and a comma
			}
		}
		// If any values were added, remove the trailing comma and execute the INSERT SQL command
		if (!values.isEmpty()) {
			values = values.substring(0, values.length() - 2); // Remove trailing comma and space
			fields = fields.substring(0, fields.length() - 2);   // Remove trailing comma and space
			super.execute("INSERT INTO " + TABLE_NAME + "(" + fields + ") values(" + values + ");");
		}
	}

	// Method to delete records from the table based on a specific condition
	public void delete(String whatField, String whatValue) {
		// Execute a DELETE statement where the specified field equals the provided value
		super.execute("DELETE from " + TABLE_NAME + " where " + whatField + " = " + whatValue + ";");
	}

	// Method to update records in the table
	public void update(String whatField, String whatValue, String whereField, String whereValue) {
		// Execute an UPDATE statement to set a new value for a field where a condition is met
		super.execute("UPDATE " + TABLE_NAME + " set " + whatField + " = \"" + whatValue + "\" where " + whereField + " = \"" + whereValue + "\";");
	}

	// Method to select records from the table and return the results as a nested ArrayList
	public ArrayList<ArrayList<Object>> select(String fields, String whatField, String whatValue, String sortField, String sort) {
		// Construct the query using prepareSQL and execute it via the inherited executeQuery method
		return super.executeQuery(prepareSQL(fields, whatField, whatValue, sortField, sort));
	}

	// Method to execute an arbitrary SQL query and return its result as a nested ArrayList
	public ArrayList<ArrayList<Object>> getExecuteResult(String query) {
		return super.executeQuery(query);
	}

	// Method to execute an SQL command (e.g., INSERT, UPDATE, DELETE) without returning a result
	public void execute(String query) {
		super.execute(query);
	}

	// Method to select records and return the results as a DefaultTableModel for use in GUI components
	public DefaultTableModel selectToTable(String fields, String whatField, String whatValue, String sortField, String sort) {
		// Construct the query and convert the result to a DefaultTableModel using the inherited method
		return super.executeQueryToTable(prepareSQL(fields, whatField, whatValue, sortField, sort));
	}
}