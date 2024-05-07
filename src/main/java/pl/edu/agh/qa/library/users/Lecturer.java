package pl.edu.agh.qa.library.users;

import java.util.HashMap;

public class Lecturer extends User {
    public final byte limit = 10;

    public Lecturer(String firstName, String surname, HashMap<String, Integer> userID) {
        super(firstName, surname, userID);
    }
}
