package LearnApp.tasks;

import LearnApp.Main;
import LearnApp.objects.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Вася on 26.04.2016.
 */
public class TeacherTasksController {
    @FXML
    TextField textFieldNumber1;
    @FXML
    TextField textFieldNumber2;
    @FXML
    TextField textFieldNumber3;
    @FXML
    TextField textFieldNumber4;
    @FXML
    TextField textFieldNumber5;
    @FXML
    TextField textFieldNumber6;
    @FXML
    TextField textFieldNumber7;
    @FXML
    TextField textFieldNumber8;
    @FXML
    TextField textFieldNumber9;
    @FXML
    TextField textFieldNumber10;
    @FXML
    TextField textFieldQuestion1;
    @FXML
    TextField textFieldQuestion2;
    @FXML
    TextField textFieldQuestion3;
    @FXML
    TextField textFieldQuestion4;
    @FXML
    TextField textFieldQuestion5;
    @FXML
    TextField textFieldQuestion6;
    @FXML
    TextField textFieldQuestion7;
    @FXML
    TextField textFieldQuestion8;
    @FXML
    TextField textFieldQuestion9;
    @FXML
    TextField textFieldQuestion10;
    @FXML
    TextField textFieldAnswer1;
    @FXML
    TextField textFieldAnswer2;
    @FXML
    TextField textFieldAnswer3;
    @FXML
    TextField textFieldAnswer4;
    @FXML
    TextField textFieldAnswer5;
    @FXML
    TextField textFieldAnswer6;
    @FXML
    TextField textFieldAnswer7;
    @FXML
    TextField textFieldAnswer8;
    @FXML
    TextField textFieldAnswer9;
    @FXML
    TextField textFieldAnswer10;

    ArrayList<Task> tasks;

    @FXML
    private void initialize() throws FileNotFoundException {
        tasks = Main.getParser().getTasks();
        if(!(tasks.get(0).getQuestion().equals(""))){
        textFieldNumber1.setText("1"); textFieldQuestion1.setText(tasks.get(0).getQuestion()); textFieldAnswer1.setText(tasks.get(0).getAnswer());
        textFieldNumber2.setText("2"); textFieldQuestion2.setText(tasks.get(1).getQuestion()); textFieldAnswer2.setText(tasks.get(1).getAnswer());
        textFieldNumber3.setText("3"); textFieldQuestion3.setText(tasks.get(2).getQuestion()); textFieldAnswer3.setText(tasks.get(2).getAnswer());
        textFieldNumber4.setText("4"); textFieldQuestion4.setText(tasks.get(3).getQuestion()); textFieldAnswer4.setText(tasks.get(3).getAnswer());
        textFieldNumber5.setText("5"); textFieldQuestion5.setText(tasks.get(4).getQuestion()); textFieldAnswer5.setText(tasks.get(4).getAnswer());
        textFieldNumber6.setText("6"); textFieldQuestion6.setText(tasks.get(5).getQuestion()); textFieldAnswer6.setText(tasks.get(5).getAnswer());
        textFieldNumber7.setText("7"); textFieldQuestion7.setText(tasks.get(6).getQuestion()); textFieldAnswer7.setText(tasks.get(6).getAnswer());
        textFieldNumber8.setText("8"); textFieldQuestion8.setText(tasks.get(7).getQuestion()); textFieldAnswer8.setText(tasks.get(7).getAnswer());
        textFieldNumber9.setText("9"); textFieldQuestion9.setText(tasks.get(8).getQuestion()); textFieldAnswer9.setText(tasks.get(8).getAnswer());
        textFieldNumber10.setText("10"); textFieldQuestion10.setText(tasks.get(9).getQuestion()); textFieldAnswer10.setText(tasks.get(9).getAnswer());
        }
    }

    public void saveTasks(ActionEvent actionEvent) throws IOException {
        if (textFieldNumber1.getText().isEmpty() || textFieldAnswer1.getText().isEmpty() || textFieldQuestion1.getText().isEmpty() || textFieldNumber2.getText().isEmpty() || textFieldAnswer2.getText().isEmpty() || textFieldQuestion2.getText().isEmpty()||textFieldNumber3.getText().isEmpty() || textFieldAnswer3.getText().isEmpty() || textFieldQuestion3.getText().isEmpty()||textFieldNumber4.getText().isEmpty() || textFieldAnswer4.getText().isEmpty() || textFieldQuestion4.getText().isEmpty()||textFieldNumber5.getText().isEmpty() || textFieldAnswer5.getText().isEmpty() || textFieldQuestion5.getText().isEmpty()||textFieldNumber6.getText().isEmpty() || textFieldAnswer6.getText().isEmpty() || textFieldQuestion6.getText().isEmpty()||textFieldNumber7.getText().isEmpty() || textFieldAnswer7.getText().isEmpty() || textFieldQuestion7.getText().isEmpty()||textFieldNumber8.getText().isEmpty() || textFieldAnswer8.getText().isEmpty() || textFieldQuestion8.getText().isEmpty() || textFieldNumber9.getText().isEmpty() || textFieldAnswer9.getText().isEmpty() || textFieldQuestion9.getText().isEmpty() || textFieldNumber10.getText().isEmpty() || textFieldAnswer10.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Заполните все поля!");
            alert.showAndWait();
        } else{
            tasks.set(Integer.parseInt(textFieldNumber1.getText()) - 1, new Task(textFieldQuestion1.getText(), textFieldAnswer1.getText()));
            tasks.set(Integer.parseInt(textFieldNumber2.getText()) - 1, new Task(textFieldQuestion2.getText(), textFieldAnswer2.getText()));
            tasks.set(Integer.parseInt(textFieldNumber3.getText()) - 1, new Task(textFieldQuestion3.getText(), textFieldAnswer3.getText()));
            tasks.set(Integer.parseInt(textFieldNumber4.getText()) - 1, new Task(textFieldQuestion4.getText(), textFieldAnswer4.getText()));
            tasks.set(Integer.parseInt(textFieldNumber5.getText()) - 1, new Task(textFieldQuestion5.getText(), textFieldAnswer5.getText()));
            tasks.set(Integer.parseInt(textFieldNumber6.getText()) - 1, new Task(textFieldQuestion6.getText(), textFieldAnswer6.getText()));
            tasks.set(Integer.parseInt(textFieldNumber7.getText()) - 1, new Task(textFieldQuestion7.getText(), textFieldAnswer7.getText()));
            tasks.set(Integer.parseInt(textFieldNumber8.getText()) - 1, new Task(textFieldQuestion8.getText(), textFieldAnswer8.getText()));
            tasks.set(Integer.parseInt(textFieldNumber9.getText()) - 1, new Task(textFieldQuestion9.getText(), textFieldAnswer9.getText()));
            tasks.set(Integer.parseInt(textFieldNumber10.getText())-1, new Task(textFieldQuestion10.getText(),textFieldAnswer10.getText()));
            Main.getParser().addTasks(tasks);
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }
}
