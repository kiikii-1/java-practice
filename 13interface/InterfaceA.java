import java.util.*;

/*interfaceはメソットは宣言だけ。
実装はimplementsがやる
interfaceのメソッドは 暗黙的に public。

interface が保証しているのは👇
このメソッドは 必ず存在する
引数・戻り値は 必ずこの形
呼び出し側は 中身を知らなくていい*/
interface Payment{
    void pay(int amount);
}
public class InterfaceA {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        String way = sc.next();
        int price = sc.nextInt();
        /*箱を作る */
        Payment payment;

        if(way.equals("cash")) {
        payment = new CashPayment();
        } else if (way.equals("credit")){
        payment = new CreditPayment();
        } else {
            System.out.println("支払方法が不正です");
            return;
        }
        payment.pay(price);
    }
}

class CashPayment implements Payment {
    /*interfaceのメソッドは 暗黙的に publicだから
    implemtnts側はpublicをつける */
    public void pay (int amount) {
        System.out.println(amount + "円を現金で支払いました");
    }
}
class CreditPayment implements Payment {
    public void pay (int amount) {
        System.out.println(amount + "円をクレジットカードで支払いました");
    }
}
