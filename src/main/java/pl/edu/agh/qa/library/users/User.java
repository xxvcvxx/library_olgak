package pl.edu.agh.qa.library.users;

import java.util.HashMap;

public abstract class User {
    public String firstName;
    public String surname;
    public String cardId;
    HashMap<String, Integer> userID = new HashMap<>();

    public User(String firstName, String surname, String cardId, HashMap<String, Integer> userID) {
        this.firstName = firstName;
        this.surname = surname;
        this.userID = userID;
        this.cardId = cardId;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    protected void setSurname(String surname) {
        this.surname = surname;
    }

    protected void setUserID(HashMap<String, Integer> userID) {
        this.userID = userID;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
