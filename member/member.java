import java.util.*;

public class member {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User[] users = new User[3]; //三つの箱を作ってるだけ

        for(int i = 0; i < 3; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            users[i] = new User(name, age);//箱を要素入れた状態のオブジェクトにする
        }

        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].name + " " + users[i].age);
        }
    }
}

class User {
    String name;//ないとだめ？？
    int age;//ないとだめ？？

    User(String name, int age){
        this.name = name;
        this.age = age;
    }
}

    /*for(int i = 0; i < 3; i++) {
        Scanner name = sc.next();
        Scanner age = sc.nextInt();
            System.out.println(name);
            System.out.println(age);
    }
}
        /*String[] Arrayn = name.split("");

        Scanner age = sc.next();
        String[] Arraya = age.split("");*/

