import java.util.*;

public class psytest {
    public static void main(String args[]) {

        System.out.println("これはabcd診断");
        System.out.println("質問を始めます");

        /*
         * QuestionListクラスのインスタンスを作りコンストラクタが実行され、
         * ゲッターであるgetQuestionList()メソッドを実行してquestionlistに入れる;
         * 
         * QuestionクラスはID,text,abcdgataが入ってるもの
         * のListで定義したものがquestionList
         */
        List<Question> questionlist = new QuestionList().getQuestionList();

        for (int i = 0; i < questionlist.size(); i++) {
            Question question = questionlist.get(i);
            System.out.println(question.getQuestionId() + ": " + question.getQuestionText());

        }
    }
}
