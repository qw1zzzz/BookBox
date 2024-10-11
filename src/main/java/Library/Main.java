package Library;

import java.util.Scanner;

public class Main {
    static Scanner scan;
    static DataBase dataBase;
    public static void main(String[] args) {

        dataBase = new DataBase();
        System.out.println("Welcome to Library!");

        int exit;
        //while (exit == 0) {
            System.out.println(
                    "0. Exit\n" +
                    "1. Login\n" +
                    "2. New User");
            scan = new Scanner(System.in);
            int answer = scan.nextInt();

            switch(answer) {
                case 1: login(); break;
                case 2: newUser(); login(); break;
                default:
                    System.out.println("Not a valid option!");
            }
        //}
    }

    private static void login() {
        System.out.println("Enter login:");
        String login = scan.next();
        System.out.println("Enter password:");
        String password = scan.next();
        int answer = dataBase.login(login, password);
        if (answer != -1) {
            User usr = dataBase.getUser(answer);
            System.out.println("\n==Welcome " + usr.getName() + "==\n");
            usr.menu(dataBase, usr);
        } else {
            System.out.println("Error user not found!");
        }
    }

    private static void newUser() {
        System.out.println("Enter login:");
        String login = scan.next();

        System.out.println("Enter password");
        String password = scan.next();

        System.out.println("Enter name:");
        String name = scan.next();

        System.out.println(
                "1. Admin\n" +
                "2. Normal user");

        int answer = scan.nextInt();
        User usr;
        if (answer == 1) {
            usr = new Admin(name, login, password);
        } else {
            usr = new NormalUser(name, login, password);
        }
        dataBase.AddUser(usr);
        System.out.println(
                "Registration completed!" +
                "\nLogin in your account\n");
    }
}