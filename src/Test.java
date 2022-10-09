import java.util.HashMap;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        User user1 = new User();
        User user2 = new User();


            user1.subscribe(user2);

        System.out.println(user1.getSubscription());
    }
}


/* 
  Server server = new Server();
       server.register();
       server.register();

       HashMap<String, User> users = server.getUsers();
       System.out.println(users.containsKey("7713644944"));

          System.out.println("Please, enter your phone to get an access to account: "); String phone = in.nextLine();
          if (users.containsKey(phone)) {
          	User user = users.get(phone);
             System.out.println("Please, enter the password: ");
             String gotPassword = in.nextLine();
             if (gotPassword.equals(user.getPassword())) {
             	System.out.println("You have entered successfully!!!");
             	System.out.println(user.getName());
             }
             else {
             	System.out.println("Wrong Password, bastard!!!");
             }
          }
*/