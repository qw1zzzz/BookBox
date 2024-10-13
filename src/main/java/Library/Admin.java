package Library;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String name) {
        super(name);
        this.operations = new InOutOperation[] {
                new ViewBooks(),
                new AddBook(),
                new DeleteBook(),
                new SearchBook(),
                new DeleteAllBooks(),
                new Exit()
        };
    }
    
    public Admin (String name, String login, String password) {
        super(name, login, password);
        this.operations = new InOutOperation[] {
                new ViewBooks(),
                new AddBook(),
                new DeleteBook(),
                new SearchBook(),
                new DeleteAllBooks(),
                new Exit()
        };
    }

    @Override
    public void menu(DataBase database, User user) {
        System.out.println(
                "1. View books\n" +
                "2. Add book\n" +
                "3. Delete book\n" +
                "4. Search book\n" +
                "5. Delete all books\n" +
                "6. Exit\n");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database, user);
        s.close();
    }

    public String toString() {
        return name + "<N/>" + login + "<N/>" + password + "<N/>" + "Admin";
    }

}

