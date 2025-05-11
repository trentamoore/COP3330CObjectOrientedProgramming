// Class representing an episode in a series
class Episode {
    private String title;
    private int season;
    private double rating;

    // Constructor to initialize Episode attributes
    public Episode(String title, int season, double rating) {
        this.title = title;
        this.season = season;
        this.rating = rating;
    }

    // Getters for accessing attributes
    public String getTitle() { return title; }
    public int getSeason() { return season; }
    public double getRating() { return rating; }

    // Returns a formatted string representation of an Episode object
    @Override
    public String toString() {
        return "Episode{title='" + title + "', season=" + season + ", rating=" + rating + "}";
    }
}
