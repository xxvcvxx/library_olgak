package pl.edu.agh.qa.library.users;

import java.util.HashMap;

public class Student extends User {
    public int limit = 4;

    public Student(String firstName, String surname, String cardId, HashMap<String, Integer> userID, int limit) {
        super(firstName, surname, cardId, userID);
        this.limit = limit;
    }
}
