package LearnApp.objects;

/**
 * Created by Вася on 25.04.2016.
 */
public class Task {

    private String question;
    private String answer;

    public Task(){}

    public Task(String question, String answer) {
        this.setQuestion(question);
        this.setAnswer(answer);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
