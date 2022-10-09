import java.util.HashMap;

class Server {
    private HashMap<String, User> users = new HashMap<>();

    public void register(){
        User user = new User();
        users.put(user.getPhone_number(), user);
    }

    public HashMap<String, User> getUsers(){
        return users;
    }
}