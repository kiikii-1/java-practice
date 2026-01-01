import java.util.Scanner;

public class scanner{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
        }

        int i = sc.nextInt();
        System.out.println(i);

        String s = sc.next();
        String line = sc.nextLine();
        
        sc.close();
    }
}