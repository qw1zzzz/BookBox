package Library;

import java.util.ArrayList;

public class DataBase {
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<String> userNames = new ArrayList<String>();

    public void AddUser(User usr){
        users.add(usr);
        userNames.add(usr.getName());
    }

    public int login(String phoneNumber, String email) {
        int answer = -1;
        for(User usr : users){
            if (usr.getPhoneNumber().equals(phoneNumber) && usr.getEmail().equals(email)) {
                answer = users.indexOf(usr);
                break;
            }
        }
        return answer;
    }

    public User getUser(int index) {
        return users.get(index);
    }
}
