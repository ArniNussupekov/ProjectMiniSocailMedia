import java.util.HashMap;
import java.util.Scanner;

class UserInterface {
   private boolean isLogged;
   private Server server;
   private User loggedUser;
   private int choice = 0;
   private Scanner in;

      UserInterface(){
         isLogged = false;
         server = new Server();
         in = new Scanner(System.in);
      }

      public void mainProcess(){
       printMainMenu();

        while (choice != 3) {
            choice = in.nextInt();
               if (choice == 1){
                 logIn();
               }
               if (choice == 2){
                 server.register();
               }
               if (choice == 3){
                  System.exit(0);
               }
        }
      }
      public void logIn(){
         String number = in.nextLine();
         String password = in.nextLine();
          loggedUser = server.getUser(number, password);
          isLogged = true;
      }
   public void printMainMenu(){
      System.out.println("Welcome to social media! This is main menu. Please, choose what to you want");
      System.out.println("1. Log in \n2. Register \n3. Exit\n");
   }
}
