package pl.edu.agh.qa.library.items;

public class Book extends Item {
public String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
