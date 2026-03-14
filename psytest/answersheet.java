import java.util.HashMap;
import java.util.Map;

public class answersheet {
    /*
     * クラスっぽく扱いたいときに大文字Integer
     * private int questionId;
     * private int questionAnswer;
     */
    private Map<Integer, Integer> answers = new HashMap<Integer, Integer>();

    /* IDと回答を保存するメソッド→MapにIdとanswerを入れる */
    public void saveAnswer(int questionId, int questionAnswer) {
        answers.put(questionId, questionAnswer);
    }
}
