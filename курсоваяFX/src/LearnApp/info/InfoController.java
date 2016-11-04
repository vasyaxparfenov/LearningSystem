package LearnApp.info;

import LearnApp.Main;
import LearnApp.objects.Student;

import javafx.beans.property.SimpleBooleanProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;



import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by Вася on 30.04.2016.
 */
public class InfoController {



    ObservableList<Student> students;


    @FXML
    TableView<Student> tableStudents;
    @FXML
    TableColumn<Student,String> fioTableColumn;
    @FXML
    TableColumn<Student,String> groupTableColumn;
    @FXML
    TableColumn<Student,String> varTableColumn;
    @FXML
    TableColumn<Student, Integer> markTableColumn;
    @FXML
    TableColumn<Student,String> accessTableColumn;
    @FXML
    TableColumn<Student, Boolean> btnTableColumn;
    @FXML
    TableColumn<Student,Boolean> deleteTableColumn;
    @FXML
    Button saveBtn;

    @FXML
    private void initialize() throws FileNotFoundException {
        students = FXCollections.observableArrayList(Main.getParser().getStudents());
        fioTableColumn.setCellValueFactory(new PropertyValueFactory<>("FIO"));
        groupTableColumn.setCellValueFactory(new PropertyValueFactory<>("group"));
        varTableColumn.setCellValueFactory(new PropertyValueFactory<>("var"));
        markTableColumn.setCellValueFactory(new PropertyValueFactory<>("mark"));
        accessTableColumn.setCellValueFactory(new PropertyValueFactory<>("access"));
        btnTableColumn.setCellValueFactory(param -> new SimpleBooleanProperty(param.getValue() != null));
        btnTableColumn.setCellFactory(param -> new ButtonCell());
        deleteTableColumn.setCellValueFactory(param -> new SimpleBooleanProperty(param.getValue() != null));
        deleteTableColumn.setCellFactory(param -> new DeleteButtonCell());
        saveBtn.setDisable(true);
        tableStudents.setEditable(true);
        tableStudents.setItems(students);
        tableStudents.scrollTo(students.size());
    }

    public void exit(ActionEvent actionEvent) throws IOException {
        Parent root = Main.getLoader().load(getClass().getResource("../../view/teacher.fxml"));
        Main.getPrimaryStage().setScene(new Scene(root, 600, 400));
        Main.getPrimaryStage().show();
    }

    public void save(ActionEvent actionEvent) throws IOException {
        Main.getParser().updateObservableStudents(students);
        saveBtn.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Список учеников");
        alert.setContentText("Список учеников изменен!");
        alert.showAndWait();

    }


    private class ButtonCell extends TableCell<Student, Boolean> {
        Button cellButton = new Button("Пересдача");

        ButtonCell(){

            cellButton.setOnAction(event -> {
                if (ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex()).isPassed())
                    {
                            ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex()).setPassed(false);
                            ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex()).setAccess("Допущен");
                            ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex()).setMark(0);
                            ButtonCell.this.getTableView().edit(ButtonCell.this.getIndex(), accessTableColumn);
                            ButtonCell.this.getTableView().edit(ButtonCell.this.getIndex(), markTableColumn);
                    }
                else
                    {
                        ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex()).setPassed(true);
                        ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex()).setAccess("Не допущен");
                        ButtonCell.this.getTableView().edit(ButtonCell.this.getIndex(),accessTableColumn);
                    }
                saveBtn.setDisable(false);
            });

        }


        @Override
        protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if(!empty){
                setGraphic(cellButton);
            }
            else{
                setGraphic(null);
            }
        }
    }

    private class DeleteButtonCell extends TableCell<Student, Boolean> {
        Button deleteButton = new Button("Удалить");

        DeleteButtonCell(){
            deleteButton.setOnAction(event -> {
                DeleteButtonCell.this.getTableView().getItems().remove(DeleteButtonCell.this.getIndex());
                saveBtn.setDisable(false);
            });
        }

        @Override
        protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if(!empty){
                setGraphic(deleteButton);
            }
            else{
                setGraphic(null);
            }
        }
    }
}
