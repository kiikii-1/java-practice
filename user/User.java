import java.util.*;

public class User {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int age = sc.nextInt();

        Users user = new Users(name, age);
            System.out.println(user.name);
            System.out.println(user.age);
    }
}
class Users {
    String name;
    int age;

    Users(String name, int age) {
        this.name = name;//this.nameがフィールドで=nameが引数
        this.age = age;

    }
}