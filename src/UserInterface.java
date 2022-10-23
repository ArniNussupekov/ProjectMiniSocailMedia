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

        while (choice != 3) {
            printMainMenu();
            choice = in.nextInt();
               if (choice == 1){
                   System.out.print("Enter your phone number and password: ");
                   String number = in.next();
                   String password = in.next();
                   logIn(number, password);
               }
               if (choice == 2){
                 server.register();
               }
               if (choice == 3){
                  System.exit(0);
               }
        }
      }
      public void logIn(String number, String password){
          try {
              loggedUser = server.getUser(number, password);
              isLogged = true;
              System.out.println("You have logged successfully!");
          } catch (Exception ex){
              ex.printStackTrace();
          }
      }
   public void printMainMenu(){
      System.out.println("Welcome to social media! This is main menu. Please, choose what to you want");
      System.out.println("1. Log in \n2. Register \n3. Exit\n");
   }
}
