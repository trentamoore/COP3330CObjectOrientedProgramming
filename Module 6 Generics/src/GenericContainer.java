import java.util.*;

// Generic container class to hold objects of any type
class GenericContainer<T> {
    private List<T> items; // List to store items

    // Constructor initializes an empty ArrayList
    public GenericContainer() {
        this.items = new ArrayList<>();
    }

    // Adds an item to the container
    public void add(T item) { items.add(item); }

    // Removes an item from the container
    public void remove(T item) { items.remove(item); }

    // Retrieves an item by index
    public T get(int index) { return items.get(index); }

    // Returns the number of items in the container
    public int size() { return items.size(); }

    // Prints all items in the container
    public void printAll() { items.forEach(System.out::println); }

    // Sorts items based on the provided comparator
    public void sort(Comparator<T> comparator) {
        items.sort(comparator);
    }
}
