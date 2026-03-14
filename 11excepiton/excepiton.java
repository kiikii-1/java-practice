import java.util.*;

public class excepiton {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        //var A = sc.next();
        //int a = Integer.percentInt(A);
        try{
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(n);
        } catch (NumberFormatException e) {
            System.out.println("error");
            
        }
            
    }
}
