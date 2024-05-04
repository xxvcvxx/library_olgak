package pl.edu.agh.qa.library.users;

import java.util.HashMap;

public class Lecturer extends User {

    public Lecturer(String firstName, String surname, String cardId, HashMap<String, Integer> userID) {
        super(firstName, surname, cardId, userID);
    }
}
