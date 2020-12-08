package Main;

import Utility.Global;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    private TableView table;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Interfaces/AdminOrdersListPage.fxml"));
        primaryStage.getIcons().add(new Image("file:src/Views/Resources/images/icon.png"));
        Global.setPrimaryStage(primaryStage);
        Stage ps = Global.getPrimaryStage();
        ps.setTitle("BookStore");
        Scene scene = new Scene(root);
        ps.setScene(scene);
        ps.show();
        Global.getCurrentUser().setFullName("Med Aziz Njaimi");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
