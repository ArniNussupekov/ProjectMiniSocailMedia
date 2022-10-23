import java.util.HashMap;

class Server {
    private HashMap<String, User> users = new HashMap<>();

    public User getUser(String phone, String password){
        User user;
        if (users.containsKey(phone)){
            user = users.get(phone);
                if (user.getPassword().equals(password)){
                    return user;
                }
                else {
                    System.out.println("Wrong! ");
                    return null;
                }
        }
        return null;
    }
    public void register(){
        User user = new User();
        users.put(user.getPhone_number(), user);
    }

    public HashMap<String, User> getUsers(){
        return users;
    }
}