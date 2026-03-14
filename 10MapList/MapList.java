import java.util.*;

public class MapList {
    public static void main(String[]args) {
        int ID;
        String name;
    
        List<User> UserList = new ArrayList<>();
        Map<Integer, User> UserMap = new HashMap<>();
        
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");

        UserList.add(u1);
        UserList.add(u2);
        UserList.add(u3);

        UserMap.put(u1.ID,u1);
        UserMap.put(u2.ID,u2);
        UserMap.put(u2.ID,u3);

        Scanner sc =  new Scanner(System.in);
        
        /*名前一覧表示 */
        for(User userA : UserList) {
            System.out.println(userA.name);
        }

        /*ID検索 */
        int IDa = sc.nextInt();
        if(UserMap.containsKey(IDa)){
            User A = UserMap.get(IDa);
            System.out.println(A.name +" "+ A.ID);
        }else {
            System.out.println("該当なし");
        }
}
}

class User{
    int ID;
    String name;

    User(int ID, String name){
        this.ID = ID;
        this.name = name;

    }
}
