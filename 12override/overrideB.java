import java.util.*;

public class overrideB {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        User user;
        if(name.equals ("admin")){
            /*AdminUserオブジェクトを作ってuserという箱に入れる */
            user = new AdminUser(name);
        } else {
            user = new User(name);
            //System.out.println(getRole());
        }
        user.showInfo();
    }
}
class User{
    String name;
    /*コンストラクタ */
    User(String name){
        this.name = name;
    }
    
    String getRole(){
        return "User";
    }
    void showInfo(){
        System.out.println("名前：" + (name));
        System.out.println("名前：" + (getRole()));
        System.out.println((name) + (canDelete() ? "は削除できます" : "は削除できません"));
    }
        //System.out.println("削除権限：" + (user.canDelete() ? "あり": "なし"));
    boolean canDelete(){
        return false;
    }
}

class AdminUser extends User{
    //String name;
    AdminUser(String name){
        super(name);
        //this.name = name;
    }
    @Override
    String getRole() {
        return "Admin";
    }
    @Override
    boolean canDelete(){
        return true;
    }
}
