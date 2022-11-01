import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class UserInterface {
   private boolean isLogged;
   private Server server;
   private User loggedUser;
   private User chosenUser;
   private int choice = 0;
   private Scanner in;

      UserInterface(){
         isLogged = false;
         server = new Server();
         in = new Scanner(System.in);
      }

      public void mainProcess(){
        while (choice != 3) {
            printMainMenu();
            choice = in.nextInt();
               if (choice == 1){
                   System.out.print("Enter your phone number and password: ");
                   String number = in.next();
                   String password = in.next();
                   logIn(number, password);

                     usage();
               }
               if (choice == 2){
                 server.register();
               }
               if (choice == 3){
                  System.exit(0);
               }
        }
      }

      void usage(){
          while (choice != 5) {
              printUsage();
              choice = in.nextInt();
              if (choice == 1){
                  loggedUser.createPost();
              }
              if (choice == 2) {
              makeComment();
              }
              if (choice == 3) {
              subscribe();
              }
              if (choice == 4) {
              unsubscribe();
              }
              if (choice == 5) {

              }
          }
      }

    private void unsubscribe() {
        System.out.println("Enter phone number to person who you want unsubscribe: ");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        HashMap<String, User> users = server.getUsers();

       try {
           loggedUser.unsubscribe(users.get(number));
       } catch (Exception e){
           System.exit(0);
       }
        System.out.println("Unsubscribed successfully!");
        System.out.println(number);
        System.out.println(loggedUser.getSubscription());
    }

    public void subscribe(){
        System.out.println("Enter phone number to person who you want subscribe: ");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        HashMap<String, User> users = server.getUsers();

        try {
            loggedUser.subscribe(users.get(number));
            System.out.println("Subscribed successfully!");
        } catch (Exception e){
            System.exit(0);
        }
        System.out.println(users.get(number));
        System.out.println(loggedUser.getSubscription());
      }

      public void makeComment(){
          LinkedList<Post> posts;
          Scanner sc = new Scanner(System.in);
          Post post;
            try {
                chosenUser = chooseUser();
                System.out.println("Choose post that you want to comment (where first is 0 and so on): ");
                System.out.println(chosenUser.getPosts());

                System.out.println("enter your comment2");
                   posts = chosenUser.getPosts();
                   post = posts.get(sc.nextInt());

          post.makeComment();
                System.out.println("Comment done!");
            } catch (Exception ex){
                System.exit(0);
            }
      }
      public User chooseUser(){
          Scanner sc = new Scanner(System.in);
          HashMap<String, User> users = server.getUsers();
          System.out.println("Enter the phone number of user: ");
          String theUser = sc.nextLine();
          System.out.println(users.get(theUser));
          return users.get(theUser);
      }
    public void logIn(String number, String password){
          try {
              loggedUser = server.getUser(number, password);
              isLogged = true;
              System.out.println("You have logged successfully!");
          } catch (Exception ex){
              ex.printStackTrace();
              System.exit(0);
          }
      }

   private void printUsage(){
       System.out.println("What do you want?");
       System.out.println("1. Create post\n 2. Comment Post\n 3. Subscribe\n 4.Unsubscribe\n 5. Exit");
   }
   private void printMainMenu(){
      System.out.println("Welcome to social media! This is main menu. Please, choose what to you want");
      System.out.println("1. Log in \n2. Register \n3. Exit\n");
   }
}
