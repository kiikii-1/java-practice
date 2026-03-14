package error;

public class error {
    /*Strint型sを３－５字目で区切ってint型にしてiへ */
    int i = Integer.parseInt(s.substring(3, 5));
    /*int型iを３－５字目で区切ってint型にしてmへ */
    String s = Integer.toString(i);
    /* falseで初期化。if、flagがtrueなら*/
     boolean flag = false;
        if (flag) { 
        }
    /*n個入る配列int[]aを作る→for文内でlistに入れていく */
    int count = sc.nextInt();
        int[] alist = new int[count];
    for...alist[i] = sc.nextInt();
    /*n[i]にm[j]が含まれているか */
    if(n[i].contains(m[j])) {


    /*昇順
    配列ならArrays.sort(配列名);、
    ListならCollections.sort(リスト名); */
    Arrays.sort(nList);
    /*配列の降順
    Collectionsクラスの.reverseOrder()メソットを使う
    .reverseOrder() が返すのはComparator<オブジェクト>
    比較Comparatorは(Tオブジェクト型のa, T b)を比較する仕組み。
    だからIntegerジェネリクス型で定義する。*/
    Integer[] a = new Integer[n];
    Arrays.sort(a, Collections.reverseOrder());
    /*canDelete()はboolean型。がtrueのとき：falseのとき */
    System.out.println((user.canDelete() ? "可" : "不可"));
    
    /*配列の要素番号1の数を比較する
    x番目y番目の要素番号[0]を比較。return-なら降順
    +なら */
    Arrays.sort(pea,(x, y)->{
    /*これと同じ意味
    Arrays.sort(pea, new Comparator<int[]>() {
    public int compare(int[] x, int[] y) {*/
            if(x[0] != y[0]) {
                return y[0] - x[0];
            }else{
                return y[1] - x[1];
            }
        });
/* マップを昇順→リストに変換(…keySet()で
Mapに入っているキー（名前）だけを全部集めた集合
をkeylistに入れる
→昇順*/
ArrayList<String> keyList = new ArrayList<>(pa.keySet());
        Collections.sort(keyList);