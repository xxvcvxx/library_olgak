package pl.edu.agh.qa.library.users;

public class Student extends User {

    public Student(String firstName, String surname) {
        super(firstName, surname);
        limit = 4;
    }
}
