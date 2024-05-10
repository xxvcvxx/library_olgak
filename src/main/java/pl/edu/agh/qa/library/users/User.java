package pl.edu.agh.qa.library.users;

import java.util.HashMap;

public abstract class User {
    protected String firstName;
    protected String surname;
    protected int cardId;
    protected byte limit;
    HashMap<String, Integer> userID = new HashMap<>();


    public User(String firstName, String surname, HashMap<String, Integer> userID) {
        this.firstName = firstName;
        this.surname = surname;
        this.userID = userID;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    protected void setSurname(String surname) {
        this.surname = surname;
    }

    public byte getLimit() {
        return limit;
    }

    protected void setUserID(HashMap<String, Integer> userID) {
        this.userID = userID;
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

    public HashMap<String, Integer> getUserID() {
        return userID;
    }
}
