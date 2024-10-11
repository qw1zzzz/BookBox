package Library;

public abstract class User {
    protected String name;
    protected String login;
    protected String password;
    protected InOutOperation[] operations;

    public User() {}
    public User(String name) {
        this.name = name;
    }
    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    abstract public void menu(DataBase database, User user);
}
