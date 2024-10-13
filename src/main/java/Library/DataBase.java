package Library;

import java.io.*;
import java.util.ArrayList;

public class DataBase {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> userNames = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<String> bookNames = new ArrayList<String>();

    private File usersFile = new File("D:\\Projects\\Java\\Library\\src\\main\\resources\\Users");
    private File booksFile = new File("D:\\Projects\\Java\\Library\\src\\main\\resources\\Books");
    private File pathWhereCreateFolder = new File("D:\\Projects\\Java\\Library\\src\\main\\resources");

    public DataBase() {
        if (!pathWhereCreateFolder.exists()) {
            pathWhereCreateFolder.mkdir();
        }
        if (!usersFile.exists()) {
            try {
                usersFile.createNewFile();
            } catch (Exception e) {}

        }
        if (!booksFile.exists()) {
            try {
                booksFile.createNewFile();
            } catch (Exception e) {}
        }
        getUsers();
    }

    public void AddUser(User usr){
        users.add(usr);
        userNames.add(usr.getName());
        saveUsers();
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
        saveBooks();
    }

    private void getUsers() {
        String text1 = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(usersFile));
            String s1;
            while ((s1 = br1.readLine()) != null) {
                text1 += s1;
            }
            br1.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        if (!text1.matches("") || !text1.isEmpty()) {
            String[] a1 = text1.split("<NewUser/>");
            for (String s : a1) {
                String[] a2 = s.split("<N/>");
                if (a2[3].matches("Admin")) {
                    User user = new Admin(a2[0], a2[1], a2[2]);
                    users.add(user);
                    userNames.add(a2[0]);
                } else {
                    User user = new NormalUser(a2[0], a2[1], a2[2]);
                    users.add(user);
                    userNames.add(a2[0]);
                }
            }
        }
    }

    public void saveUsers() {
        String text1 = "";
        for (User user : users) {
            text1 = user.toString() + "<NewUser/>\n";
        }
        try {
            PrintWriter pw = new PrintWriter(usersFile);
            pw.print(text1);
            pw.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void saveBooks() {
        String text1 = "";
        for (Book book : books) {
            text1 = book.toString2() + "<NewBooks/>\n";
        }
        try {
            PrintWriter pw = new PrintWriter(booksFile);
            pw.print(text1);
            pw.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public Book parseBook(String s) {
        String[] a = s.split("</N>");
        Book book = new Book();
        book.setName(a[0]);
        book.setAuthor(a[1]);
        return book;
    }

    private void getBooks() {
        String text1 = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(booksFile));
            String s1;
            while ((s1 = br1.readLine()) != null) {
                text1 += s1;
            }
            br1.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        if (!text1.matches("") || !text1.isEmpty()) {
            String[] a1 = text1.split("<NewBooks/>");
            for (String s : a1) {
                Book book = parseBook(s);
                books.add(book);
                bookNames.add(book.getName());
            }
        }
    }

}
