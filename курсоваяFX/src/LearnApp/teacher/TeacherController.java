package LearnApp.teacher;
import LearnApp.Main;
import LearnApp.objects.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Вася on 20.04.2016.
 */
public class TeacherController {

    Teacher teacher = (Teacher) Main.getUser();

    @FXML
    Label fioLabel;
    @FXML
    Label subjectLabel;
    @FXML
    Label degreeLabel;

    @FXML
    private  void initialize(){
        fioLabel.setText(teacher.getFIO());
        subjectLabel.setText(teacher.getSubject());
        degreeLabel.setText(teacher.getDegree());
    }

    public void showResults(ActionEvent actionEvent) throws IOException {
        Parent root = Main.getLoader().load(getClass().getResource("../../view/info.fxml"));
        Main.getPrimaryStage().setScene(new Scene(root, 600, 400));
        Main.getPrimaryStage().show();
    }

    public void showTest(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = Main.getLoader().load(getClass().getResource("../../view/teacherTasks.fxml"));
        stage.setTitle("Редактирование тестов");
        stage.setMinHeight(432);
        stage.setMinWidth(600);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        Stage primaryStage = Main.getPrimaryStage();
        stage.initOwner(primaryStage);
        stage.show();
    }

    public void showInfo(ActionEvent actionEvent) throws IOException {
        Parent root = Main.getLoader().load(getClass().getResource("../../view/material.fxml"));
        Main.getPrimaryStage().setScene(new Scene(root, 600, 400));
        Main.getPrimaryStage().show();
    }

    public void exit(ActionEvent actionEvent) throws IOException {
        Parent root = Main.getLoader().load(getClass().getResource("../../view/authorization.fxml"));
        Main.getPrimaryStage().setScene(new Scene(root, 600, 400));
        Main.getPrimaryStage().show();
    }
}
