import java.util.*;

public class InterfaceC {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        String menb = sc.next();
        int price = sc.nextInt();

        Discount discount;
        if(menb.equals("member")){
            discount = new MemberDiscount();
        } else {
            discount = new NormalDiscount();
        }
        int result = discount.calc(price);
        System.out.println(result);
    }
}
interface Discount {
    /*計算した結果を int で返します */
    int calc(int price);
}

class NormalDiscount implements Discount{
    public int calc(int price){
    return price;
    }
}
class MemberDiscount implements Discount{
    /*interfaceでdouble型は返せない。
    だから型変換（キャスト）をしている
    小数点以下を切り捨てて int にする */
    public int calc(int price){
    return (int)(price*0.9);
    }
}