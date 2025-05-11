import java.util.*;

// Utility class for generic methods
class GenericUtility {
    // Generic method to find the index of a value in an array
    public static <T> int findIndex(T[] array, T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i; // Return the index if the value is found
            }
        }
        return -1; // Return -1 if the value is not found
    }
}
