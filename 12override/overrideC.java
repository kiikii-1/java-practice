import java.util.*;

public class overrideC {
    public static void main(String[]args) {
        List<User> UserList = new ArrayList<>();
    /*別のオブジェクトuserとAdminuserを作り、
    UserListに追加 */
    UserList.add(new User("taro"));
    UserList.add(new AdminUser("taro"));
    }
}
