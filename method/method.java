import java.util.Scanner;

public class method{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        //int c = nextInt();

        System.out.println(add(a, b));
        System.out.println(subtract(a, b));
        System.out.println(multiply(a, b));
        System.out.println(divide(a, b));
    }

        static int add(int a, int b){
            return a + b;
        }
        static int subtract(int a, int b){
            return a - b;
        }
        static int multiply(int a, int b){
            return a * b;    
        }
        static int divide(int a, int b){
            return a / b;    
        }
    
}

