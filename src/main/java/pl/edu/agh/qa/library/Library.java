package pl.edu.agh.qa.library;

import pl.edu.agh.qa.library.items.Book;
import pl.edu.agh.qa.library.items.Item;
import pl.edu.agh.qa.library.items.Magazine;
import pl.edu.agh.qa.library.users.Student;
import pl.edu.agh.qa.library.users.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private int cardId = 1;

    private List<User> userList;
    private Map<Item, Boolean> itemMap;// false if book is borrowed
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
        try (FileReader fileReader = new FileReader(csvFile); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                String[] itemData = row.split(";");
                if (itemData[3].equals("B")) {
                    for (int i = 1; i <= (Integer.parseInt(itemData[2])); i++) {
                        addItemToLibrary(new Book(itemData[0], itemData[1]));
                    }
                } else if (itemData[3].equals("M")) {
                    for (int i = 1; i <= (Integer.parseInt(itemData[2])); i++) {
                        addItemToLibrary(new Magazine(itemData[0], itemData[1]));
                    }
                } else {
                    System.out.println("Wrong Item Type.");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public void exportUsersWithItemsToFile(String csvFile) {

    }

    public void printListOfMagazines() {
        Map<String, int[]> magazineCounts = new HashMap<>();

        for (Map.Entry<Item, Boolean> entry : itemMap.entrySet()) {
            Item item = entry.getKey();
            Boolean isAvailable = entry.getValue();

            if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                String key = magazine.getTitle() + ";" + magazine.getMagazineNumber();

                if (magazineCounts.containsKey(key)) {
                    magazineCounts.get(key)[0]++;

                    if (isAvailable) {
                        magazineCounts.get(key)[1]++;
                    }
                } else {
                    int[] counts = new int[2];
                    counts[0] = 1;

                    if (isAvailable) {
                        counts[1] = 1;
                    }
                    magazineCounts.put(key, counts);
                }
            }
        }
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

            if (item instanceof Book) {
                Book book = (Book) item;
                String key = book.getTitle() + ";" + book.getAuthor();

                if (bookCounts.containsKey(key)) {
                    bookCounts.get(key)[0]++;
                    if (isAvailable) {
                        bookCounts.get(key)[1]++;
                    }
                } else {
                    int[] counts = new int[2];
                    counts[0] = 1;
                    if (isAvailable) {
                        counts[1] = 1;
                    }
                    bookCounts.put(key, counts);
                }
            }
        }
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
