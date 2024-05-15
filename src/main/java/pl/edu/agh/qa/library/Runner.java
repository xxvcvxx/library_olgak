package pl.edu.agh.qa.library;

import pl.edu.agh.qa.library.items.Book;
import pl.edu.agh.qa.library.items.Magazine;
import pl.edu.agh.qa.library.users.Lecturer;
import pl.edu.agh.qa.library.users.Student;

import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        HashMap<String, Integer> userID = new HashMap<>();

        // Nowa biblioteka
        Library library = new Library();
        //Studenty
        Student stu = new Student("olg","olg",userID);
        Student stu1 = new Student("olg1","olg1",userID);
        Student stu2 = new Student("olg2","olg2",userID);
        Lecturer lec1=new Lecturer("Lec","lec",userID);
        //dodaje studentów i wypisuje
        library.addUserToLibrary(stu,stu1,stu2,lec1);
        library.printListOfUsers();
        //dodaje itemki
        Book book1= new Book("BookTitle","BookAutor");
        Book book2= new Book("BookTitle3","BookAutor1");
        Book book3= new Book("BookTitle","BookAutor");
        Magazine magazine1= new Magazine("MagazinAutor","12/03/2024");
        Magazine magazine2= new Magazine("MagazinAutor","12/03/2024");
        Magazine magazine3= new Magazine("MagazinAutor","12/03/2024");
        library.addItemToLibrary(book1,magazine1,magazine2,magazine3,book2,book3);
        library.printListOfMagazines();

        library.rentItemToUser(book1, stu);
        library.rentItemToUser(magazine1, stu);

        library.rentItemToUser(book1, stu2);
        library.rentItemToUser(magazine3,lec1);
        library.printListOfMagazines();
        library.printListOfBooks();
        //library.importItemsFromFile("books.csv");
        System.out.println("=================");
        library.printListOfMagazines();
        library.printListOfBooks();
        library.exportUsersWithItemsToFile("books.csv");


    }
}
