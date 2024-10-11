package Library;

import java.util.Scanner;

public class NormalUser extends User {
    public NormalUser(String name) {
        super(name);
        this.operations = new InOutOperation[] {
                new ViewBooks(),
                new SearchBook(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new Exit()
        };
    }
    public NormalUser(String name, String login, String password) {
        super(name, login, password);
        this.operations = new InOutOperation[] {
                new ViewBooks(),
                new SearchBook(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new Exit()
        };
    }

    @Override
    public void menu(DataBase database, User user) {
        System.out.println(
                "1. View books\n" +
                "2. Search book\n" +
                "3. Place order\n" +
                "4. Borrow book\n" +
                "5. Calculate Fine\n" +
                "6. Exit\n");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database, user);
        s.close();
    }
}
