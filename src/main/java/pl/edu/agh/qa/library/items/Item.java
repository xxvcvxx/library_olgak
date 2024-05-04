package pl.edu.agh.qa.library.items;

public abstract class Item {
    public String title;
    public int count = 0;
    public int availableCount=0;

    public Item(String title, int count, int availableCount) {
        this.title = title;
        this.count = count;
        this.availableCount = availableCount;
    }
}
