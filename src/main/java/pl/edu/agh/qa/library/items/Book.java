package pl.edu.agh.qa.library.items;

public class Book extends Item {
public String author;

    public Book(String title, int count, int availableCount, String author) {
        super(title, count, availableCount);
        this.author = author;
    }
}
