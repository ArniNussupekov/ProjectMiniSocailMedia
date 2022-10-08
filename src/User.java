import java.math.BigInteger;
import java.util.Scanner;

public class User {
    private Scanner in = new Scanner(System.in);
    public String name;
    public String surname;
    private int age;
    private BigInteger phone_number;

    User(){
        System.out.println("Welcome to registration! Please enter name, surname and so on");
        System.out.println("Name: "); setName(in.nextLine());
        System.out.println("Surname: "); setSurname(in.nextLine());
        System.out.println("Age: "); setAge(in.nextInt());
        System.out.println("Phone number: "); setPhone_number(new BigInteger(in.next()));
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

    public BigInteger getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(BigInteger phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return " name='" + name + '\n' +
                " surname='" + surname + '\n' +
                " age=" + age +
                "\n phone_number=" + phone_number;
    }
}
