package pl.edu.agh.qa.library;

import pl.edu.agh.qa.library.items.Book;
import pl.edu.agh.qa.library.items.Item;
import pl.edu.agh.qa.library.items.Magazine;
import pl.edu.agh.qa.library.users.Student;
import pl.edu.agh.qa.library.users.User;

import java.util.*;

public class Library {
    private int cardId = 1;

    private List<User> userList;
    private Map<Item, Boolean> itemMap;// true dostepna
    private Map<User, List<Item>> rentings;

    public Library() {
        this.userList = new ArrayList<>();
        this.itemMap = new HashMap<>();
        this.rentings = new HashMap<>();
    }

    public void addItemToLibrary(Item... item) {
        for (Item itemToAdd : item) {
            itemMap.put(itemToAdd, true);
        }
    }

    public void addUserToLibrary(User... users) {
        for (User user : users) {
            user.setCardId(cardId++);
            userList.add(user);
        }
    }

    public boolean rentItemToUser(Item item, User user) {
        boolean itemIsAlreadyRented = !itemMap.get(item);
        if (itemIsAlreadyRented) {
            return false;
        }

        List<Item> userItems = rentings.get(user);
        if (userItems != null) {
            int itemsRentedByUser = userItems.size();
            if (itemsRentedByUser > user.getLimit()) {
                return false;
            }
        }

        if (userItems == null) {
            userItems = new ArrayList<>();
            rentings.put(user, userItems);
        }
        userItems.add(item);
        itemMap.put(item, false);
        return true;
    }

    public void importItemsFromFile(String csvFile) {
    }

    public void exportUsersWithItemsToFile(String csvFile) {
    }

    public void printListOfMagazines() {
        Map<String, int[]> magazineCounts = new HashMap<>();

        for (Map.Entry<Item, Boolean> entry : itemMap.entrySet()) {
            Item item = entry.getKey();
            Boolean isAvailable = entry.getValue();

            if (item instanceof Magazine) { // Sprawdź, czy przedmiot jest typu Magazine
                Magazine magazine = (Magazine) item;
                String key = magazine.getTitle() + ";" + magazine.getMagazineNumber();

                if (magazineCounts.containsKey(key)) {
                    magazineCounts.get(key)[0]++; // Zwiększ całkowitą liczbę przedmiotów

                    if (isAvailable) {
                        magazineCounts.get(key)[1]++; // Zwiększ liczbę dostępnych przedmiotów
                    }
                } else {
                    int[] counts = new int[2];
                    counts[0] = 1; // Całkowita liczba przedmiotów

                    if (isAvailable) {
                        counts[1] = 1; // Liczba dostępnych przedmiotów
                    }
                    magazineCounts.put(key, counts);
                }
            }
        }

        // Wyświetl zliczenia dla magazynów
        System.out.println("=== Magazines ===");
        for (Map.Entry<String, int[]> entry : magazineCounts.entrySet()) {
            String[] parts = entry.getKey().split(";");
            String title = parts[0];
            String magazineNumber = parts[1];
            int[] counts = entry.getValue();
            int totalCount = counts[0];
            int availableCount = counts[1];
            System.out.println(title + ";" + magazineNumber + ";" + totalCount + ";" + availableCount);
        }


    }

    public void printListOfBooks() {
        Map<String, int[]> bookCounts = new HashMap<>();

        for (Map.Entry<Item, Boolean> entry : itemMap.entrySet()) {
            Item item = entry.getKey();
            Boolean isAvailable = entry.getValue();

            if (item instanceof Book) { // Sprawdź, czy przedmiot jest typu Book
                Book book = (Book) item;
                String key = book.getTitle() + ";" + book.getAuthor();

                if (bookCounts.containsKey(key)) {
                    bookCounts.get(key)[0]++; // Zwiększ całkowitą liczbę przedmiotów

                    if (isAvailable) {
                        bookCounts.get(key)[1]++; // Zwiększ liczbę dostępnych przedmiotów
                    }
                } else {
                    int[] counts = new int[2];
                    counts[0] = 1; // Całkowita liczba przedmiotów

                    if (isAvailable) {
                        counts[1] = 1; // Liczba dostępnych przedmiotów
                    }
                    bookCounts.put(key, counts);
                }
            }
        }

        // Wyświetl zliczenia dla książek
        System.out.println("=== Books ===");
        for (Map.Entry<String, int[]> entry : bookCounts.entrySet()) {
            String[] parts = entry.getKey().split(";");
            String title = parts[0];
            String author = parts[1];
            int[] counts = entry.getValue();
            int totalCount = counts[0];
            int availableCount = counts[1];
            System.out.println(title + ";" + author + ";" + totalCount + ";" + availableCount);
        }
    }

    public void printListOfUsers() {
        char userType;
        for (User user : userList) {
            if (user instanceof Student) {
                userType = 'S';
            } else {
                userType = 'L';
            }
            System.out.println(user.getFirstName() + ";" + user.getSurname() + ";" + user.getCardId() + ";" + userType);
        }
    }

}
