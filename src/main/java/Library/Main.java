package Library;

import java.util.Scanner;

public class Main {
    static Scanner scan;
    static DataBase dataBase;
    public static void main(String[] args) {

        dataBase = new DataBase();
        System.out.println("Welcome to Library!");

        int exit = 0;
        while (exit == 0) {
            System.out.println(
                    "0. Exit\n" +
                    "1. Login\n" +
                    "2. New User");
            scan = new Scanner(System.in);
            int answer = scan.nextInt();

            switch(answer) {
                case 0: exit = 1; break;
                case 1: login(); break;
                case 2: newUser(); break;
                default:
                    System.out.println("Not a valid option!");
            }
        }
    }

    private static void login() {
        System.out.println("Enter phone number:");
        String phoneNumber = scan.next();
        System.out.println("Enter email:");
        String email = scan.next();
        int answer = dataBase.login(phoneNumber, email);
        if (answer != -1) {
            User usr = dataBase.getUser(answer);
            System.out.println("Welcome " + usr.getName());
            usr.menu();
        } else {
            System.out.println("User not found!");
        }
    }

    private static void newUser() {
        System.out.println("Enter name:");
        String name = scan.next();

        System.out.println("Enter phone number:");
        String phoneNumber = scan.next();

        System.out.println("Enter email:");
        String email = scan.next();
        System.out.println("1. Admin\n" +
                "2. Normal user");

        int answer = scan.nextInt();
        User usr;
        if (answer == 1) {
            usr = new Admin(name, email, phoneNumber);
        } else {
            usr = new NormalUser(name, email, phoneNumber);
        }
        dataBase.AddUser(usr);
        usr.menu();
    }
}