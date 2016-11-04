package LearnApp.registration;

import LearnApp.Main;
import LearnApp.objects.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;


import java.io.*;
import java.util.ArrayList;


public class RegistrationController {
    @FXML
    private TextField txtFIO;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtGroup;

    @FXML
    private TextField txtVar;

    Alert alert;

    public void onButtonClicked(ActionEvent actionEvent) throws IOException {
        if(txtFIO.getText().isEmpty() || txtGroup.getText().isEmpty() || txtLogin.getText().isEmpty() || txtPassword.getText().isEmpty() || txtVar.getText().isEmpty())
        {
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Заполните все поля!");
            alert.showAndWait();
        }
        else{
            Student student = new Student(txtPassword.getText(), txtLogin.getText(), txtFIO.getText(), txtGroup.getText(), txtVar.getText());
            ArrayList<Student> students = Main.getParser().getStudents();
            int result = Add(students, student);

            switch (result){
                case 1:
                    Main.getParser().updateStudents(students);
                    Node source = (Node) actionEvent.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                    break;
                case 2:
                    alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Такой логин уже существует!");
                    alert.showAndWait();
                    break;
                case 3:
                    alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Такой студент уже зарегестрирован!");
                    alert.showAndWait();
                    break;
                case 4:
                    alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Неверный вариант!");
                    alert.showAndWait();
                    break;
            }

        }
    }



    public int Add(ArrayList<Student> students, Student checkStudent){

        if (students == null) {
            students = new ArrayList<>();
        }
        for (Student student : students) {
            if (student.getLogin().equals(checkStudent.getLogin())) {
                return 2;
            }
            if (student.getFIO().equals(checkStudent.getFIO())) {
                return 3;
            }
            if (student.getGroup().equals(checkStudent.getGroup()) && student.getVar().equals(checkStudent.getVar())) {
                return 4;
            }
        }
        students.add(checkStudent);

        return 1;
    }

}
