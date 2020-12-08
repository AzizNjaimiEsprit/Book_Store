package Views.Controllers;

import Beans.OnlineBook;
import Services.CrudOnlineBook;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class testCont implements Initializable {
    CrudOnlineBook crudOnlineBook = new CrudOnlineBook();
    @FXML
    private TextField textField;
    ArrayList<OnlineBook> test = crudOnlineBook.RecupererListLivreEnLigne();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> list = test.stream().map(p->p.getTitle()).collect(Collectors.toList());
        TextFields.bindAutoCompletion(textField,list);
    }

    public void showBook(MouseEvent mouseEvent) {
        System.out.println(textField.getText());
        OnlineBook onlineBook = test.stream().filter(p -> p.getTitle().equals(textField.getText())).findFirst().get();
        System.out.println(onlineBook);
    }
}
