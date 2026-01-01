public class hello {
    public static void main(String[] args) {
        System.out.println("Java動いた");

        int a = 2;
        int list []= {1,2,3,4,5};
        int sum = 0;
        int max = list[0];// ← ここで定義＆初期化している

        if (a % 2 == 0) {
            System.out.println("偶数");
        } else {
            System.out.println("奇数");
        }

        for (int i = 0; i<list.length; i++) {
            sum += list[i];

            if (list[i] > max){
                max = list[i];

            }
        }
            System.out.println("最大値" + max);
            System.out.println("合計" + sum);
        
    }
}
