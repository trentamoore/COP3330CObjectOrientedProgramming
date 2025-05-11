// Class representing a character in a show
class Character {
    private String name;
    private int age;
    private String role;

    // Constructor to initialize Character attributes
    public Character(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    // Getters for accessing attributes
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getRole() { return role; }

    // Returns a formatted string representation of a Character object
    @Override
    public String toString() {
        return "Character{name='" + name + "', age=" + age + ", role='" + role + "'}";
    }
}
