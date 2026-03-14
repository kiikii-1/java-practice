import java.util.*;
public class 9IDSearch{
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> IDmap = new Map<>();
        
        for(int i = 0; i < 3; i++) {
            int ID = sc.nextInt();
            String name = sc.next();
            IDmap.put(ID, name);
        }
        /*四回目の入力で何IDを探したいかを入力。
        例；２→二番目を探す */
        int IDsearch = sc.nextInt();

        if(IDmap.containsKey(IDsearch)) {
            System.out.println(IDmap.get(IDsearch));
        } else {
            System.out.println("Not found");
        }
        }
}




/*練習用
public class IDSearch {
    public static void main(String[]args) {

    Map<Integer, String> map = new HasMap<>();
    map.put(1, "A");
    map.put(2, "B");
    map.put(2, "newB");//BからnewBに更新、上書き
    
    System.out.println(map.get(1));
    }
}*/

/*paiza練習用
public class Main {
    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();

    int[] alist = new int[count];

    for(int i = 0; i < count; i++) {
        alist[i] = sc.nextInt();
    }

    int k = sc.nextInt();

     for(int i = 0; i < count; i++) {
        if(alist[i] == k) {
            System.out.println(alist[i]);
            break;
        }

    
    }
}*/



