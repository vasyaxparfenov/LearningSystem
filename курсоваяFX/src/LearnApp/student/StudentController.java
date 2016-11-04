package LearnApp.student;
import LearnApp.Main;
import LearnApp.objects.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * Created by Вася on 16.04.2016.
 */
public class StudentController {


    Student student = (Student) Main.getUser();

    @FXML
    Label fioLabel;
    @FXML
    Label groupLabel;
    @FXML
    Label varLabel;
    @FXML
    Label markLabel;
    @FXML
    Label mark;
    @FXML
    Button btnTest;

    @FXML
         private void initialize(){
            fioLabel.setText(student.getFIO());
            groupLabel.setText(student.getGroup());
            varLabel.setText(student.getVar());
            if(student.isPassed()){
                mark.setText("Оценка :");
                markLabel.setText(String.valueOf(student.getMark())+"/100");
                btnTest.setDisable(true);
            }

    }

    public void showCourse(ActionEvent actionEvent) throws IOException {
        Parent root = Main.getLoader().load(getClass().getResource("../../view/material.fxml"));
        Main.getPrimaryStage().setScene(new Scene(root, 600, 400));
        Main.getPrimaryStage().show();
    }

    public void showTest(ActionEvent actionEvent) throws IOException {
        Parent root = Main.getLoader().load(getClass().getResource("../../view/studentTasks.fxml"));
        Main.getPrimaryStage().setScene(new Scene(root, 600, 415));
        Main.getPrimaryStage().show();
    }


    public void exit(ActionEvent actionEvent) throws IOException {
        Parent root = Main.getLoader().load(getClass().getResource("../../view/authorization.fxml"));
        Main.getPrimaryStage().setScene(new Scene(root, 600, 400));
        Main.getPrimaryStage().show();
    }
}
