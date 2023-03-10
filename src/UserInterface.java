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
          while (choice != 9) {
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
              likePost();
              }
              if (choice == 6) {
                  blockUser();
              }
              if (choice == 7) {
                  unblockUser();
              }
              if (choice == 8) {
                  getMax();
              }
          }
      }

      private void getMax(){
          System.out.println("\tGet Max of your posts");
          Scanner in = new Scanner(System.in);
          System.out.println("Enter number of posts");
          int number = in.nextInt();
          System.out.println(loggedUser.getMax(number));
      }

    private void unblockUser(){
        System.out.println("\tUnblock User");
        chosenUser = chooseUser();
        if (loggedUser.getPhone_number().equals(chosenUser.getPhone_number())){
            System.out.println("You can't unblock yourself!");
            return;
        }
        loggedUser.unblockUser(chosenUser.getPhone_number());
        System.out.println(loggedUser.getBlockList());
    }
      private void blockUser(){
          System.out.println("\tBlock User");
          chosenUser = chooseUser();
          if (loggedUser.getPhone_number().equals(chosenUser.getPhone_number())){
              System.out.println("You can't block yourself!");
              return;
          }
          loggedUser.blockUser(chosenUser.getPhone_number());
          System.out.println(loggedUser.getBlockList());
      }

      private void likePost(){
          LinkedList<Post> posts;
          Scanner sc = new Scanner(System.in);
          Post post;
          try {
              chosenUser = chooseUser();
              if (chosenUser.getBlockList().contains(loggedUser.getPhone_number())){
                  System.out.println("You are blocked!");
                  return;
              }
              System.out.println("Choose post that you want to like (where first is 0 and so on): ");
              System.out.println( posts = chosenUser.getPosts());

                post = posts.get(sc.nextInt());
                if (loggedUser.likedPosts.contains(post)){
                    System.out.println("You have already liked this post!");
                    return;
                }

                         post.likePost();
                         loggedUser.likedPosts.add(post);
                         System.out.println("You Liked");
          } catch (Exception ex){
              System.out.println("Error when you tried like post");
              System.exit(0);
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
           System.out.println("Wrong id");
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
            if (users.get(number).getBlockList().contains(loggedUser.getPhone_number())){
                System.out.println("You are blocked!");
                return;
            }
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
                if (chosenUser.getBlockList().contains(loggedUser.getPhone_number())){
                    System.out.println("You are blocked!");
                    return;
                }
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
       System.out.println("1. Create post\n 2. Comment Post\n 3. Subscribe\n 4.Unsubscribe \n5.Like post \n6. Block User \n 7.Unblock user\n8.Get max\n9.Exit");
   }
   private void printMainMenu(){
      System.out.println("Welcome to social media! This is main menu. Please, choose what to you want");
      System.out.println("1. Log in \n2. Register \n3. Exit\n");
   }
}
