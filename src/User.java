import java.util.LinkedList;
import java.util.Scanner;

public class User {
    private Scanner in = new Scanner(System.in);
    public String name;
    public String surname;
    private int age;
    private String phone_number;
    private LinkedList<User> subscription;
    private String password;
    public LinkedList<Post> posts;

    User(){
        System.out.println("Welcome to registration! Please enter name, surname and so on");
        System.out.println("Name: "); setName(in.nextLine());
        System.out.println("Surname: "); setSurname(in.nextLine());
        System.out.println("Age: "); setAge(in.nextInt());
        System.out.println("Phone number: "); setPhone_number(in.next());
        System.out.println("Set the password: "); setPassword(in.next());
        subscription = new LinkedList<>();
        posts = new LinkedList<>();
    }

    //actions
    public void subscribe(User user) {
        subscription.add(user);
    }
    public void unsubscribe(User user){
        subscription.remove(user);
    }
    public void createPost(String post) {
        posts.add(new Post(post));
    }

    //staff
    public LinkedList<Post> getPosts() {
        return posts;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public LinkedList<User> getSubscription(){
        return subscription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return " name: " + name + '\n' +
                " surname: " + surname + '\n' +
                " age: " + age +
                "\n phone_number: " + phone_number +
                "\n Subscribed users: " + subscription;
    }
}
