package LearnApp.objects;

/**
 * Created by Вася on 08.04.2016.
 */
public class User {
        protected String password;
        protected String login;
        protected String FIO;

    public User(){}


    public User(String password,String login,String FIO){
        this.password = password;
        this.login = login;
        this.FIO = FIO;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }
}

