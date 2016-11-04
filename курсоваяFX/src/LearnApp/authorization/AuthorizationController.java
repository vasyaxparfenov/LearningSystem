package LearnApp.authorization;

import LearnApp.Main;
import LearnApp.objects.Student;
import LearnApp.objects.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Вася on 11.04.2016.
 */
public class AuthorizationController {

    private Stage stage;



    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private CheckBox chooseBtn;


    public void showRegistrationForm(ActionEvent actionEvent) throws IOException {



            stage = new Stage();
            Parent root = Main.getLoader().load(getClass().getResource("../../view/registration.fxml"));
            stage.setTitle("Регистрация на курс");
            stage.setMinHeight(300);
            stage.setMinWidth(300);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            Stage primaryStage = Main.getPrimaryStage();
            stage.initOwner(primaryStage);
            stage.show();


    }

    public void showUserForm(ActionEvent actionEvent) throws IOException {
        if (txtLogin.getText().isEmpty() || txtPassword.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Введите логин и пароль!");
            alert.showAndWait();

        }
        else {
            int res;
            if (chooseBtn.isSelected()) {
                res = CheckTeacher(txtLogin.getText(), txtPassword.getText());
                switch (res) {
                    case 1:
                        Parent root = Main.getLoader().load(getClass().getResource("../../view/teacher.fxml"));
                        Main.getPrimaryStage().setScene(new Scene(root, 600, 400));
                        Main.getPrimaryStage().show();
                        break;
                    case 2:
                        System.out.println("Wrong password");
                        showAlert(2);
                        break;
                }
            } else {

                res = CheckStudent(txtLogin.getText(), txtPassword.getText());
                switch (res) {
                    case 1:
                        System.out.println("No students");
                        showAlert(1);
                        break;
                    case 2:
                        Parent root = Main.getLoader().load(getClass().getResource("../../view/student.fxml"));
                        Main.getPrimaryStage().setScene(new Scene(root, 600, 400));
                        Main.getPrimaryStage().show();

                        break;
                    case 3:
                        System.out.println("Wrong password");
                        showAlert(2);
                        break;
                }

            }
        }

    }

    public void showAlert(int res){
        Alert alert = new Alert(Alert.AlertType.ERROR);;
        switch (res){
            case 1: alert.setHeaderText("Ошибка");alert.setContentText("Зарегестриуйтесь на курс");alert.showAndWait();break;
            case 2: alert.setContentText("Неверный пароль или логин!"); alert.showAndWait(); break;
        }
    }

    public int CheckStudent(String login, String password) throws FileNotFoundException {
        ArrayList<Student> students = Main.getParser().getStudents();
        if(students == null) {
            return 1;
        }
        for(int i=0; i<students.size();i++){
            if(students.get(i).getLogin().equals(login) && students.get(i).getPassword().equals(password)) {
                Main.setUser(students.get(i));
                return 2;
            }
        }


        return 3;
    }
    public int CheckTeacher(String login, String password) throws FileNotFoundException {
        Teacher checkTeacher = Main.getParser().getTeacher();
        if(checkTeacher.getLogin().equals(login) && checkTeacher.getPassword().equals(password)){
            Main.setUser(checkTeacher);
            return 1;
        }
        return 2;
    }


}
