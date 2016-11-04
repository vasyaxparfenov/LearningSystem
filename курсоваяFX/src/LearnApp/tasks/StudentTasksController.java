package LearnApp.tasks;

import LearnApp.objects.Student;
import LearnApp.objects.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import LearnApp.Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Вася on 26.04.2016.
 */
public class StudentTasksController {
    @FXML
    Label lblQuestion1;
    @FXML
    Label lblQuestion2;
    @FXML
    Label lblQuestion3;
    @FXML
    Label lblQuestion4;
    @FXML
    Label lblQuestion5;
    @FXML
    Label lblQuestion6;
    @FXML
    Label lblQuestion7;
    @FXML
    Label lblQuestion8;
    @FXML
    Label lblQuestion9;
    @FXML
    Label lblQuestion10;

    @FXML
    TextField txtFieldAnswer1;
    @FXML
    TextField txtFieldAnswer2;
    @FXML
    TextField txtFieldAnswer3;
    @FXML
    TextField txtFieldAnswer4;
    @FXML
    TextField txtFieldAnswer5;
    @FXML
    TextField txtFieldAnswer6;
    @FXML
    TextField txtFieldAnswer7;
    @FXML
    TextField txtFieldAnswer8;
    @FXML
    TextField txtFieldAnswer9;
    @FXML
    TextField txtFieldAnswer10;

    @FXML
    Button saveBtn;

    ArrayList<Task> tasks;
    int count;

    @FXML
    private void initialize() throws FileNotFoundException {
        tasks = Main.getParser().getTasks();
        if(tasks != null){
            lblQuestion1.setText(tasks.get(0).getQuestion());
            lblQuestion2.setText(tasks.get(1).getQuestion());
            lblQuestion3.setText(tasks.get(2).getQuestion());
            lblQuestion4.setText(tasks.get(3).getQuestion());
            lblQuestion5.setText(tasks.get(4).getQuestion());
            lblQuestion6.setText(tasks.get(5).getQuestion());
            lblQuestion7.setText(tasks.get(6).getQuestion());
            lblQuestion8.setText(tasks.get(7).getQuestion());
            lblQuestion9.setText(tasks.get(8).getQuestion());
            lblQuestion10.setText(tasks.get(9).getQuestion());
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Задание времено недоступно");
            alert.showAndWait();
        }
    }
    public void saveAnswers(ActionEvent actionEvent) throws IOException {
        if(txtFieldAnswer1.getText().isEmpty() || txtFieldAnswer2.getText().isEmpty() || txtFieldAnswer3.getText().isEmpty()|| txtFieldAnswer4.getText().isEmpty()|| txtFieldAnswer5.getText().isEmpty()|| txtFieldAnswer6.getText().isEmpty()|| txtFieldAnswer7.getText().isEmpty()|| txtFieldAnswer8.getText().isEmpty()|| txtFieldAnswer9.getText().isEmpty()|| txtFieldAnswer10.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Заполните все поля ответов(если не знаете правильного ответа напишите не знаю)!");
            alert.showAndWait();
        }
        else {
            count = 0;
            checkAnswer(txtFieldAnswer1.getText(), 1);
            checkAnswer(txtFieldAnswer2.getText(), 2);
            checkAnswer(txtFieldAnswer3.getText(), 3);
            checkAnswer(txtFieldAnswer4.getText(), 4);
            checkAnswer(txtFieldAnswer5.getText(), 5);
            checkAnswer(txtFieldAnswer6.getText(), 6);
            checkAnswer(txtFieldAnswer7.getText(), 7);
            checkAnswer(txtFieldAnswer8.getText(), 8);
            checkAnswer(txtFieldAnswer9.getText(), 9);
            checkAnswer(txtFieldAnswer10.getText(), 10);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Тест");
            alert.setTitle("Результат тестирования");
            alert.setContentText("Вы ответили правильно на " + count + " из 10 вопросов и набрали " + count * 10 + " баллов. Для завершения тестирования нажмите кнопку Завершить тестирование");
            alert.showAndWait();
            ((Student) Main.getUser()).setMark(count * 10);
            ((Student) Main.getUser()).setPassed(true);
            ((Student) Main.getUser()).setAccess("Не допущен");
            Main.getParser().setMark(Main.getUser().getLogin(), count * 10);

            saveBtn.setDisable(true);
            txtFieldAnswer1.setText("");
            txtFieldAnswer1.setText("");
            txtFieldAnswer1.setText("");
            txtFieldAnswer1.setText("");
            txtFieldAnswer1.setText("");
            txtFieldAnswer1.setText("");
            txtFieldAnswer1.setText("");
            txtFieldAnswer1.setText("");
            txtFieldAnswer1.setText("");
            txtFieldAnswer1.setText("");
        }
    }


    public void exit(ActionEvent actionEvent) throws IOException {
        Parent root = Main.getLoader().load(getClass().getResource("../../view/student.fxml"));
        Main.getPrimaryStage().setScene(new Scene(root, 600, 400));
        Main.getPrimaryStage().show();

    }

    public void checkAnswer(String answer, int i){
        if(answer.equals(tasks.get(i-1).getAnswer())){
            count++;
        }
    }
}
