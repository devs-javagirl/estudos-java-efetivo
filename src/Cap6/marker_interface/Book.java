package Cap6.marker_interface;

public class Book implements PhysicalProduct{
    private String title;
    private String author;

    // Constructor, getters, and setters
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
