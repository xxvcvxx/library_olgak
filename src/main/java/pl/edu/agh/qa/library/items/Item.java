package pl.edu.agh.qa.library.items;

public abstract class Item {
    public String title;

    public String getTitle() {
        return title;
    }

    public Item(String title) {
        this.title = title;
    }
}
