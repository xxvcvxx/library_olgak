package pl.edu.agh.qa.library;

import pl.edu.agh.qa.library.items.Item;
import pl.edu.agh.qa.library.users.Student;
import pl.edu.agh.qa.library.users.User;

import java.util.List;
import java.util.Map;

public class Library {
    private int cardId = 1;
    private List<User> userList;
    private Map<Item, int[]> itemsCountMap;

    public Library(List<User> userList, Map<Item, int[]> itemsCountMap) {
        this.userList = userList;
        this.itemsCountMap = itemsCountMap;
    }

    public void addItemToLibrary(Item... item) {
        for (Item item1 : item) {
            if (itemsCountMap.containsValue(item1.getTitle())) { // tutu
                int allCopies = itemsCountMap.get(item1)[0];
                int availableCopies = itemsCountMap.get(item1)[1];
                int[] copies = {allCopies + 1, availableCopies + 1};
                itemsCountMap.put(item1, copies);
            } else {
                int[] copies = {1, 1};
                itemsCountMap.put(item1, copies);
            }
        }
    }

    public void addUserToLibrary(User... users) {
        for (User user : users) {
            user.setCardId(cardId);
            cardId++;
            userList.add(user);
        }
    }

    public boolean rentItemToUser(Item item, User user) {
        return false;
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
