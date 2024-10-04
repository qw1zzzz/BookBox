package Library;

public class Admin extends User {
    public Admin(String name) {
        super(name);
    }
    public Admin (String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }

    @Override
    public void menu() {
        System.out.println("" +
                "1. View books\n" +
                "2. Add book\n" +
                "3. Delete book\n" +
                "4. Search book\n" +
                "5. Delete all books\n" +
                "6. View orders\n" +
                "7. Exit\n");
    }
}

