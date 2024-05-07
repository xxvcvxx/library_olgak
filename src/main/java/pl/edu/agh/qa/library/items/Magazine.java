package pl.edu.agh.qa.library.items;

public class Magazine extends Item {
    public String magazineNumber;

    public String getMagazineNumber() {
        return magazineNumber;
    }

    public Magazine(String title, String magazineNumber) {
        super(title);
        this.magazineNumber = magazineNumber;
    }
}
