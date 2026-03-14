import java.util.*;

public class exceptionB {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        try {
            int a = Integer.parseInt(sc.nextLine());
            System.out.println("OK");
        } catch (NumberFormatException e) {
            System.out.println("数字を入力してください");

        }
    }
}
