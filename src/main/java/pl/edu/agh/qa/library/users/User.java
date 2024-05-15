package pl.edu.agh.qa.library.users;

public abstract class User {
    protected String firstName;
    protected String surname;
    protected int cardId;
    protected byte limit;

    public User(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public byte getLimit() {
        return limit;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public int getCardId() {
        return cardId;
    }
}
