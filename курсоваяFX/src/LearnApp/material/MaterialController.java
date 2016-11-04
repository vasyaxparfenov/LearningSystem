package LearnApp.material;

import LearnApp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by Вася on 02.05.2016.
 */
public class MaterialController {

    @FXML
    TextArea materialTextArea;
    @FXML
    Button saveBtn;

    @FXML
    public void initialize() throws IOException {
        if(!(Main.getUser().getLogin().equals("spzxonpu2016"))){
            saveBtn.setVisible(false);
            materialTextArea.setEditable(false);
        }
        if(!(Main.getParser().getMaterial().isEmpty())){
           materialTextArea.setText(Main.getParser().getMaterial());
        }
    }

    public void exit(ActionEvent actionEvent) throws IOException {
        Parent root;
        if(Main.getUser().getLogin().equals("spzxonpu2016")){
            root = Main.getLoader().load(getClass().getResource("src/LearnApp/teacher/teacher.fxml"));
        }
        else {
            root = Main.getLoader().load(getClass().getResource("src/LearnApp/student/student.fxml"));
        }

        Main.getPrimaryStage().setScene(new Scene(root, 600, 400));
        Main.getPrimaryStage().show();
    }

    public void saveMaterial(ActionEvent actionEvent) throws FileNotFoundException {
        Main.getParser().setMaterial(materialTextArea.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Материал");
        alert.setContentText("Материал изменен!");
        alert.showAndWait();
    }
}
