import java.util.*;

public class exceptionC {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        while (true){ 
        try{
            int a = Integer.parseInt(sc.nextLine());
            System.out.println(a);
            break;
        } catch (NumberFormatException e) { 
            System.out.println("数字を入力してください");
        }
    }
    }
}
