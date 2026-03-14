package kaiin;

import java.util.*;
//import java.util.Scanner;

public class kaiin {

    String name;
    int age = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User[] users = new User[3];

        for (int i = 0; i < 3; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            users[i] = new User(name, age);
        }
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].name + " " + users[i].age);
        }
    }
}

class User {
    String name;
    int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
