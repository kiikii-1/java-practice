
/*明日の課題
gemini二か月目のアプリを作る
時間があれば商品ID探したりmanagerクラスを作る
*/
import java.util.*;

public class paysystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("商品idを入力：");
        int id = sc.nextInt();

        GoodsManager manager = new GoodsManager();
        Goods goods = manager.findById(id);

        System.out.println("数量を入力：");
        int amount = sc.nextInt();

        System.out.println("購入方法を選択：Aクレジット Bぺいぺい C現金");
        String payway = sc.next();
        sc.nextLine();

        Pay pay = null;

        if (payway.equals("A")) {
            pay = new CreditPayment();
        } else if (payway.equals("B")) {
            pay = new PaypayPayment();
        } else if (payway.equals("C")) {
            pay = new CashPayment();
        }
        /*
         * pay というオブジェクトの
         * paymentメソッドを実行
         * どのクラスのpaymentかは
         * オブジェクトで決まる
         * これが ポリモーフィズム（多態性）。
         */
        pay.payment(goods, amount);
    }
}

/*
 * 購入者が「購入」を選択
 * 支払方法は？
 * 入力：方法
 */

class Goods {
    private int id;
    private int price;
    private String name;

    Goods(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}

class GoodsManager {
    List<Goods> goodsList = new ArrayList<>();

    /*
     * コンストラクタ
     * new GoodsManager()
     * のとき呼びたいから。
     */
    public GoodsManager() {
        goodsList.add(new Goods(1, 100, "りんご"));
        goodsList.add(new Goods(2, 100, "みかん"));
        goodsList.add(new Goods(3, 100, "もも"));
    }

    /* 商品検索 */
    public Goods findById(int id) {
        for (Goods g : goodsList) {
            if (g.getId() = id) {
                return g;
            }
        }
        return null;
    }
}

/*
 * 親クラス＝抽象クラス抽象メソットにする。
 * Payクラスは未完成のクラス
 * 「支払い」はあるけど
 * 支払い方法は決めてない
 */
abstract class Pay {
    public void payment(Goods goods, int amount) {
        double rate = getRate();
        double sum = goods.getPrice() * amount * rate;

        System.out.println(goods.getName() + "支払い：" + sum + "円");
    }

    /*
     * このメソッドは存在する
     * でも中身は書かない
     * 子クラスが必ず作れ = 設計だけ書いている
     */
    public abstract double getRate();
}

class CreditPayment extends Pay {
    public double getRate() {
        return 1.03;
    }
}

class PaypayPayment extends Pay {
    public double getRate() {
        return 1.01;
    }
}

class CashPayment extends Pay {
    public double getRate() {
        return 1.0;
    }
}