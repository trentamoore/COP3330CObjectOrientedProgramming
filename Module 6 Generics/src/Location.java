// Class representing a location
class Location {
    private String name;
    private String city;
    private boolean iconic;

    // Constructor to initialize Location attributes
    public Location(String name, String city, boolean iconic) {
        this.name = name;
        this.city = city;
        this.iconic = iconic;
    }

    // Getters for accessing attributes
    public String getName() { return name; }
    public String getCity() { return city; }
    public boolean isIconic() { return iconic; }

    // Returns a formatted string representation of a Location object
    @Override
    public String toString() {
        return "Location{name='" + name + "', city='" + city + "', iconic=" + iconic + "}";
    }
}
