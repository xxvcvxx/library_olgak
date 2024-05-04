package pl.edu.agh.qa.library.items;

public class Magazine extends Item {
    public String magazineNumber;

    public Magazine(String title, int count, int availableCount, String magazineNumber) {
        super(title, count, availableCount);
        this.magazineNumber = magazineNumber;
    }
}
