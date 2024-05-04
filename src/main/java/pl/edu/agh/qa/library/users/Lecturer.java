package pl.edu.agh.qa.library.users;

import java.util.HashMap;

public class Lecturer extends User {
    public int limit = 10;

    public Lecturer(String firstName, String surname, String cardId, HashMap<String, Integer> userID, int limit) {
        super(firstName, surname, cardId, userID);
        this.limit = limit;
    }
}
