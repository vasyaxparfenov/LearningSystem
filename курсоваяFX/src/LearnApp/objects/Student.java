package LearnApp.objects;

/**
 * Created by Вася on 10.04.2016.
 */
public class Student extends User {
        private String group;
        private String var;
        private int mark;
        private boolean passed;
        private String access;


        public Student(String password, String login, String FIO, String group, String var) {
        super(password, login, FIO);
        this.var = var;
        this.group = group;
        this.mark = 0;
        this.passed = false;
        this.access = "Допущен";

    }



    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
