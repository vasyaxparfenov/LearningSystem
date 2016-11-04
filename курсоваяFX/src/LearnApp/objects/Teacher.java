package LearnApp.objects;

/**
 * Created by Вася on 10.04.2016.
 */
public class Teacher extends User {
    private String subject;
    private String degree;

    public Teacher(String password, String login, String FIO, String degree, String sublect) {
        super(password, login, FIO);
        this.degree = degree;
        this.subject = sublect;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String sublect) {
        this.subject = sublect;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
