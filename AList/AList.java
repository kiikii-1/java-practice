import java.util.ArrayList;
import java.util.Scanner;

public class AList {
    static ArrayList<String> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        inString();
        printString();
    }

    static void inString() {
        for (int i = 0; i < 3; i++) {
            String word = sc.next();
            list.add(word);
        }
    }

    static void printString() {
        // for (int i = 0; i < list.size(); i++) {
        // System.out.println(list.get(i));
        for (String s : list) {// sにlistの中身をひとつずつ入れる
            System.out.println(s);
        }
    }
}
