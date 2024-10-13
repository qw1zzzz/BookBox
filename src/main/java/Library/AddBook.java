package Library;

import java.util.Scanner;

public class AddBook implements InOutOperation{

    @Override
    public void oper(DataBase database, User user) {
        Scanner s = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter book name: ");
        book.setName(s.next());
        System.out.println("Enter book's author: ");
        book.setAuthor(s.next());
        s.close();
        database.AddBook(book);
        System.out.println("Book added successfully");
    }
}
