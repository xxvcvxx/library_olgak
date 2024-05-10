package pl.edu.agh.qa.library.users;

import java.util.HashMap;

public class Student extends User {

    public Student(String firstName, String surname, HashMap<String, Integer> userID) {
        super(firstName, surname, userID);
        limit = 4;
    }
}
