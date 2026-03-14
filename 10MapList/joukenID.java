import java.util.*;

public class joukenID {
    public static void main (String[]args){

        List<User> users = new ArrayList<>(); 
        Map<Integer, User> userMap = new HashMap<>();

        /*User型のオブジェクトを作る */
        User u1 = new User(1, "A", 22);
        User u2 = new User(2, "B", 18);
        User u3 = new User(3, "C", 30);

        /*Listであるusersにオブジェクトを追加 */
        users.add(u1);
        users.add(u2);
        users.add(u3);

        /*MapであるuserMapにListのオブジェクトu1のidをキーにし、
        u1オブジェクトをキーの中身とする。 */
        userMap.put(u1.id, u1);
        userMap.put(u2.id, u2);
        userMap.put(u3.id, u3);
        
        Scanner sc  = new Scanner(System.in);

        /*年齢入力+検索 */
        System.out.println("年齢を入力：　");
        int age = sc.nextInt();
        boolean found = false;//初期値
        
        /*ListであるusersをUserクラス型のuserを新しく作り
        そこに入れていく。 */
        for(User user : users) {
        
        if(user.age >= age) {
            System.out.println(user.name + " " + user.age);
            found = true;
            /*elseにすると条件に合わない人のたびに
            「該当なし」が出てしまうから、
            ifで最終的にfoundがfalseだったら該当なしを出力する。 */
        } if(!found) {
            System.out.println("該当なし");
        }
    }
        /*id検索 */
        System.out.println("idを入力：　");
        int id = sc.nextInt();
        /*List → 全員見る必要あり（for）
        Map → キーが分かれば一発.
        だからforでまわさなくていい */
        if(userMap.containsKey(id)) {
            /*idをいれるuserという名前の変数を新しく作る*/
            User user = userMap.get(id);
            System.out.println(user.name + " " + user.age);
        } else {
            System.out.println("該当なし");
        }
}
}

class User{
    int id;
    String name;
    int age;

/*コンストラクタ。
this.フィールドのidが引数のid であるという意味 */
User(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
}
}