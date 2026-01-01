import java.util.*;

class QuestionList {
    /* クラスQuestion型のlistを作る */
    private static List<Question> questionList;

    /*
     * コンストラクタ。Arraylistのオブジェクトを作って
     * this.questionList（＝QuestionListクラスのフィールド）を代入
     * Createquestion()メソッドを実行
     */
    public QuestionList() {
        questionList = new ArrayList<>();
        createQuestion();
    }

    /*
     * 具体的な質問を入れる
     * Object型のquestionData変数にデータを入れてる
     */
    private static void createQuestion() {
        Object[][] questionData = {
                { 1, "質問", ABCDdata.A },
                { 2, "質問", ABCDdata.B },
                { 3, "質問", ABCDdata.C }
        };

        /*
         * 二次元配列のデータquestionDataの一行[]ずつ取り出して
         * Object[]型の変数dataに入れる
         */
        for (Object[] data : questionData) {
            questionList.add(new Question(
                    (int) data[0], (String) data[1], (ABCDdata) data[2]));
        }
    }

    /*
     * ゲッター
     * クラスQuestion型のlistを作ったものを外部から
     * 取得したいときのために。返す用
     */
    public List<Question> getQuestionList() {
        return questionList;
    }
}

enum ABCDdata {
    A, B, C, D
}// 4つのどれかに属する型がABCDdata

public class Question {
    /* Dimention型のdemention変数を定義 */
    private final int questionId;
    private final String questiontext;
    private final ABCDdata abcdgata;

    /*
     * クラスフィールドにコンストラクタの引数を代入
     * コンストラクタで入力を受け取ってフィールドに入れる
     */
    Question(int questionId, String questiontext, ABCDdata abcdgata) {
        this.questionId = questionId;
        this.questiontext = questiontext;
        this.abcdgata = abcdgata;
    }

    /*
     * フィールドを見るためのメソット：ゲッター
     * questionId()メソッドはフィールドを返す
     * 別のクラスからquestionIdを取得するために作る
     */
    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questiontext;
    }

    public ABCDdata getAbcdgata() {
        return abcdgata;
    }

}
