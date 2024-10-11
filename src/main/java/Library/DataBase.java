package Library;

import java.io.File;
import java.util.ArrayList;

public class DataBase {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> userNames = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<String> bookNames = new ArrayList<String>();

    private File usersFile = new File(Main.class.getClassLoader().getResource("Users").toExternalForm());
    private File booksFile = new File(Main.class.getClassLoader().getResource("Books").toExternalForm());

    public DataBase() {
        if (!usersFile.exists()) {
            usersFile.mkdirs();
        }
        if (!booksFile.exists()) {
            booksFile.mkdirs();
        }
    }

    public void AddUser(User usr){
        users.add(usr);
        userNames.add(usr.getName());
    }

    public int login(String login, String password) {
        int answer = -1;
        for(User usr : users){
            if (usr.getPassword().equals(password) && usr.getLogin().equals(login)) {
                answer = users.indexOf(usr);
                break;
            }
        }
        return answer;
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public void AddBook(Book book) {
        books.add(book);
        bookNames.add(book.getName());
    }
}
