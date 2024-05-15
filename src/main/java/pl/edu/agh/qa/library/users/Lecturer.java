package pl.edu.agh.qa.library.users;

public class Lecturer extends User {

    public Lecturer(String firstName, String surname) {
        super(firstName, surname);
        limit = 10;
    }
}
