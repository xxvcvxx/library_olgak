package pl.edu.agh.qa.library;

import pl.edu.agh.qa.library.items.Item;
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
    }

    public void printListOfBooks() {
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
