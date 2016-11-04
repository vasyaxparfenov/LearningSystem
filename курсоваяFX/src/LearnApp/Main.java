package LearnApp;

import LearnApp.data.Parser;
import LearnApp.objects.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Вася on 08.04.2016.
 */

    public class Main extends Application  {
        private static FXMLLoader loader = new FXMLLoader();
        private static Stage primaryStage;
        private static Parser parser = new Parser();
        private static User user;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static FXMLLoader getLoader() {
        return loader;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Main.user = user;
    }

    public static Parser getParser() { return parser; }

    public void setPrimaryStage(Stage primaryStage) {
        Main.primaryStage = primaryStage;
    }

    @Override
        public void start(Stage primaryStage) throws Exception{
            setPrimaryStage(primaryStage);
            Parent root = loader.load(getClass().getResourceAsStream("../view/authorization.fxml"));
            primaryStage.setTitle("LearnApp");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.setResizable(false);
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }

}



