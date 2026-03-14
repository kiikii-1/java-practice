import java.util.*;

public class overrideA {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        List <User> users = new ArrayList<>();

        for(int i = 0; i < count; i++) {
        String name = sc.next();
        String role = sc.next();

        /*箱を用意 */
        User user;
        /*入力された role が admin なら
        → AdminUser を作って user に入れる
        そうじゃなければ
        → 普通の User を作って user に入れる */
        if(role.equals("admin")){
            user = new AdminUser(name);
        } else {
            user = new User(name);
        }
        users.add(user);
        }
        /*今作った user を、一覧リストに入れてる */

        for(User user : users){
        //AdminUser adminuser = new AdminUser(name, role);
            System.out.println("名前：" + user.name);
            System.out.println("権限：" + user.getRole());
            /*user.canDelete()は
            Userなら → false
            AdminUserなら → truecanDelete 
            canDelete() が true なら "あり"
            false なら "なし" */
            System.out.println("削除権限：" + (user.canDelete() ? "あり": "なし"));
        }
        }
    }

class User{
    /*コンストラクタ
    引数がname→
    roleはUser → "User"/AdminUser → "Admin"
    とメソッドで決まる
    だから nameだけで十分 */
    String name;
    User (String name){
        this.name = name;
    }

    String getRole(){
        return "User";
    }
    boolean canDelete(){
        return false;
    }
}

class AdminUser extends User{
    AdminUser(String name) {
        /*「親クラス（User）のコンストラクタを呼ぶ」
        つまりUser(String name) */
        super(name);
    }
    @Override
    String getRole(){
        return "Admin";
    }
    @Override
    boolean canDelete(){
        return true;
    }
}
