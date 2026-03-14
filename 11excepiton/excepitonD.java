import java.util.*;

public class excepitonD {
    public static void main(String[]args) {
        List<String> list = Arrays.asList("A","B", "C");
        Scanner sc = new Scanner(System.in);

        //for(int i = 0; i < list.length(); i++)  {
        try{
            int a = Integer.parseInt(sc.nextLine());
            System.out.println(list.get(a));
        } catch(Exception e) {
            System.out.println("error");
        }
    }
}
