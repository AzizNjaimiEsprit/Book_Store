package Views.Controllers;

import Utilitaire.Global;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class testFileController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void pickImg(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show open file dialog
        File file = fileChooser.showOpenDialog(Global.getPrimaryStage());
        if (file != null) {
            System.out.println(file.getPath());
            file.renameTo(new File("C:/wamp64/www/BookStore/BooksImage/text.txt"));
        }
    }

    public void pickPdf(MouseEvent mouseEvent) {
    }
}
