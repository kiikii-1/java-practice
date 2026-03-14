import java.util.*;
/*長さ3の整数配列を用意する。
標準入力でインデックスを受け取り、
その要素を出力せよ。
範囲外なら 「index error」 と出力せよ。 */

public class excepitonE {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        var a = sc.nextLine();
        int[] arr = {10, 20, 30};
        //List<String> list = new ArrayList<>();
        //if(true){

        try {
            int index = Integer.parseInt(sc.nextLine());
            System.out.println(arr[index]);
        } catch(ArrayIndexOutOfBoundsException ne) {
            System.out.println("null error");
        }
        }
        
    }
}
