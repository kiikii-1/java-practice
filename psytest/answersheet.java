import java.util.HashMap;
import java.util.Map;

public class answersheet {
    /*
     * クラスっぽく扱いたいときに大文字Integer
     * private int questionId;
     * private int questionAnswer;
     */
    private Map<Integer, Integer> answers = new HashMap<Integer, Integer>();
    public void put(int questionId, int questionAnswer) {
        answers.put(questionId, questionAnswer);
    }
}
