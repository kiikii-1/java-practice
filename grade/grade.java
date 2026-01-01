import java.util.Scanner;

public class grade{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int people =sc.nextInt();

        int[] scores = new int[people];
        String[] rank = new String[people];
        
        for (int i = 0; i < people; i++) {
            scores[i] = sc.nextInt();
        
            if (scores[i] >= 90) {
                rank[i] = "A";
            }else if (scores[i] >= 80) {
                rank[i] = "B";
            }else if (scores[i] >= 70) {
                rank[i] = "C";
            }else {
                rank[i] = "D";
            }
        }
        for(int i = 0; i < people; i++){
            System.out.println(rank[i]);
        }
        
            
        /*if (n >= 90){
            System.out.println("A");
        }else if (n >= 80) {
            System.out.println("B");
        }else if (n >= 70) {
            System.out.println("C");
        }else {
            System.out.println("D");*/
    }
}
