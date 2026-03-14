import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/*1️⃣ CRUD完成
2️⃣ 継承まで
3️⃣ Map＋例外＋設計討論まで
例外を使う上級版にする
データをファイル保存

起動時にファイルから読み込み

Mapを使って高速検索

Stream APIを使う */

public class Kanri {
    public static void main(String[] args) {

        /*
         * インスタンス生成する。なぜ？
         * クラスは「設計図」
         * まだ何も存在していない。
         *
         * ■ インスタンスとは？
         * 設計図から実物を作った
         */
        MemberManager manager = new MemberManager();
        Scanner sc = new Scanner(System.in);

        /* 起動時ファイル読み込み */
        manager.loadFile();

        while (true) {

            System.out.println("1:追加　2:一覧表示　3:ID検索　4:会員削除 5:更新 6:ファイル保存 7:名前検索 8:終了");
            int choose = sc.nextInt();

            /*
             * 残っている改行だけを読む.
             * 次nameを読みたい時に改行を読んでしまうから
             */
            sc.nextLine();

            try {
                if (choose == 1) {

                    /*
                     * 1を選んだときだけ
                     * nameとemailを入力させる。
                     */

                    System.out.println("名前:");
                    String name = sc.nextLine();

                    System.out.println("メール:");
                    String email = sc.nextLine();

                    System.out.println("年齢:");
                    int age = sc.nextInt();

                    manager.trueMail(email);
                    manager.oneMail(email);
                    manager.checkAge(age);

                    manager.addMember(name, email, age);
                }

                /* 一覧表示 */
                else if (choose == 2) {
                    manager.getAllMembers();
                }

                /* ID検索 */
                else if (choose == 3) {
                    System.out.println("ID入力:");
                    int id = sc.nextInt();
                    /*
                     * throwsで例外が発生したらmainのfindById()に戻る。
                     * tryはエラーが発生する可能性がある処理
                     */
                    Member m = manager.findById(id);
                    System.out.println(m);
                    /* エラーが発生した時の対応（ログ出力など） */

                }

                /* 削除 */
                else if (choose == 4) {
                    System.out.println("削除ID:");
                    int id = sc.nextInt();
                    manager.removeById(id);
                }

                /* 更新 */
                else if (choose == 5) {

                    System.out.println("更新IDを入力：");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Member m = manager.findById(id);

                    System.out.println("1 名前 2 メール 3 年齢");
                    int k = sc.nextInt();
                    sc.nextLine();

                    if (k == 1) {
                        System.out.println("新しい名前:");
                        String newName = sc.nextLine();
                        m.setName(newName);
                    }
                    if (k == 2) {
                        System.out.println("新しいメール:");
                        String newMail = sc.nextLine();
                        m.setEmail(newMail);
                    }
                    if (k == 3) {
                        System.out.println("新しい年齢:");
                        int newAge = sc.nextInt();
                        m.setAge(newAge);
                    }
                }

                /* ファイル保存 */
                else if (choose == 6) {
                    // File file = sc.nextLine();
                    manager.saveFile();
                }
                /* 名前検索 */
                else if (choose == 7) {
                    System.out.println("名前検索:");
                    String name = sc.nextLine();
                    manager.findByName(name);
                }

                /* 終了 */
                else if (choose == 8) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Member {

    /*
     * フィールド
     * private…
     * 「このクラスの外から直接触れない」
     */

    private int id;
    private String name;
    private String email;
    private int age;
    private int fee = 0;

    /*
     * コンストラクタ
     * feeは0で固定だからコンストラクタに書かなくていい
     */
    public Member(int id, String name, String email, int age) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    /*
     * public → 外から使える
     * int → 返す型
     * getId → idを取得するメソッド名
     * return id → idを返している
     */

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public int getMonthlyFee() {
        return fee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
     * ■ toString()の役割
     * オブジェクトを「文字列」にするときに呼ばれる。
     */

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", email=" + email + ", age=" + age;
    }
}

class PremiumMember extends Member {

    private int fee = 5000;

    public PremiumMember(int id, String name, String email, int age) {
        super(id, name, email, age);
    }
}

/* 会員を管理するクラス */

class MemberManager {

    /*
     * フィールドはprivate
     * 変数名は小文字から始める
     */
    private List<Member> memberList = new ArrayList<>();
    private int nextId = 1;
    /*
     * Mapはインターフェース。
     * キーと値のペアでデータを管理するデータ構造の設計図
     * クラス→HashMap
     */
    private Map<Integer, Member> memberMap = new HashMap<>();

    /* 起動時ファイル読み込み */
    public void loadFile() throws Exception {
        File file = new File("members.txt");
        /* ファイルがない場合、初回起動なので何もしない */
        if (!file.exists()) {
            return;
        }
        /* ファイルを1行ずつ読む */
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            /* 例 1,田中,tanaka@mail,20 */
            String line = sc.nextLine();

            /*
             * 例 ,区切でdataの箱を作る
             * data[0] = 1
             * data[1] = 田中
             * data[2] = tanaka@mail
             * data[3] = 20
             */
            String[] data = line.split(",");

            /*
             * 文字列配列dataの最初の要素(data[0])を、
             * 符号付き整数(int型)に変換し、変数idに代入
             */
            int id = Integer.parseInt(data[0]);

            String name = data[1];
            String email = data[2];
            int age = Integer.parseInt(data[3]);

            Member m = new Member(id, name, email, age);

            memberMap.put(id, m);

            /*
             * 次のIDが既存ID + 1
             * になるようにするため。
             */
            if (id >= nextId) {
                nextId = id + 1;

            }
        }
        sc.close();
    }

    /*
     * 「リストに追加する」メソッド
     * 外からもらうものだけ引数に書く
     */
    public void addMember(String name, String email, int age) {

        /*
         * オブジェクト生成
         * ① name,email,ageを受け取る(じゃないとMember作れない)
         * ② Memberを作る
         * ③ Mapに入れる
         */
        Member member = new Member(nextId, name, email, age);
        memberList.add(member);// memverList使わないならこれいらない
        memberMap.put(nextId, member);
        nextId++;
    }

    /*
     * 一覧表示
     */

    public void getAllMembers() {
        System.out.println(memberList);
        /*
         * もしくは以下 リスト使わずmapで追加していく
         * for (Member m : memberMap.values()) {
         * System.out.println(m);
         * もしくはStreamを使う
         * ()
         */
    }

    /*
     * ID検索メソッド
     */

    public Member findById(int id) {
        Member m = memberMap.get(id);

        if (m == null) {
            /*
             * 例外処理
             * IllegalArgumentExceptionオブジェクト作成
             * ② 例外を投げる
             * ③ 今のメソッドを即終了
             * ④ このメソッドの呼び出し元（mainクラスfindById()）へ戻る
             */
            throw new IllegalArgumentException("IDが存在しません");
        }
        return m;
    }

    /* 名前検索 */
    public void findByName(String name) {
        /* Mapの中のMember一覧<member>+ Stream<Member>処理を開始 */
        memberMap.values().stream()
                /*
                 * フィルター処理
                 * ラムダ式(引数を受け取る -> 処理実行）
                 * m.getName():
                 * <Member>クラスのオブジェクト m から名前文字列を取得するメソッド（getName）を呼び出し
                 */
                .filter(m -> m.getName().contains(name))
                .forEach(System.out::println);
    }

    /* 削除 */
    /*
     * * IDにより削除メソッド
     * Iterator<Member>...
     * Javaが用意している型（クラス/インターフェース）
     * iterator()…
     * Listクラスにあるメソッド。
     * 「List を順番に読む Iterator を作る」
     */
    public void removeById(int id) {
        Iterator<Member> it = memberList.iterator();
        /*
         * * Iteratorクラスのメソッド
         * hasNext()「次の要素ある？」
         */
        while (it.hasNext()) {
            /* next()[次の要素を取り出す] */
            Member m = it.next();
            if (m.getId() == id) {
                /*
                 * * remove()
                 * [今取り出した要素を削除]
                 */
                it.remove();

            }
            /*
             * 本当はこれだけでもいい
             * // memberMap.remove(id)で削除され、次にnullかどうか判定
             * if (memberMap.remove(id) == null) {
             * throw new IllegalArgumentException("削除するIDがありません");
             * 
             * }
             */
        }
    }

    /* メール形式判定 */
    public void trueMail(String email) {

        if (!(email.contains("@"))
                && ((email.contains(".com")) || email.contains(".jp") || email.contains(".net"))) {
            throw new IllegalArgumentException("メール形式が不正です");
        }
    }

    /* メール重複 */
    public void oneMail(String email) {
        for (Member m : memberList) {
            try {
                if (m.getMail().equals(email)) {
                    throw new IllegalArgumentException("メールは登録されています。");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /* 年齢チェック */
    public void checkAge(int age) {
        try {
            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("年齢が不正です");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * ファイル保存メソッド
     * throws exceptionこのメソッドは例外を出す可能性があります
     */
    public void saveFile() throws Exception {
        /*
         * PrintWriterは
         * ファイルに文字を書くクラス
         * members.txt を作る
         */
        PrintWriter pw = new PrintWriter("members.txt");
        for (Member m : memberMap.values()) {
            pw.println(
                    m.getId() + "," +
                            m.getName() + "," +
                            m.getMail() + "," +
                            m.getAge());
        }
        pw.close();
        System.out.println("ファイルを保存しました");
    }
}