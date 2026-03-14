import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class agregate {
    private static EnumMap<ABCDdata, Integer> score;
    int Acount;
    int Bcount;
    int Ccount;
    int Dcount;

    public static void agregatemethod(List<Question> questionList, Map<Integer, Integer> answers) {
        for (int i = 0; i < questionList.size(); i++) {
            /* Questionクラスを一つ持ってきてquestion変数に入れる */
            Question question = questionList.get(i);
            /* ↑のquestionに入ってるquesionIdをgetしてquestionIdに入れる */
            int questionId = question.getQuestionId();
            /* */
            ABCDdata questionData = question.getAbcdData();
            /* ? */
            int currentScore = score.get(questionData);
            /* ? */
            int answer = answers.get(questionId);

            /*
             * ↓修正する
             * Map(Listにあるi番目のAbcddata,Listのi番目
             */
            score.put(questionList.get(i).getAbcdData(),
                    answers.get(questionList.get(i).getAbcdData()));

        }
    }
}
