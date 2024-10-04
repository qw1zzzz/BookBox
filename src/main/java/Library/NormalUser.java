package Library;

public class NormalUser extends User {
    public NormalUser(String name) {
        super(name);
    }
    public NormalUser(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }

    @Override
    public void menu() {
        System.out.println("" +
                "1. View books\n" +
                "2. Search book\n" +
                "3. Place order\n" +
                "4. Borrow book\n" +
                "5. Calculate Fine\n" +
                "6. Return book\n" +
                "7. Exit\n");
    }
}
