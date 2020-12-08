package Views.Controllers;

import Utulitaire.Global;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class MenuBarController {
    public Map<String,String> interfacesSizes =  new HashMap<>();

    public MenuBarController() {
        interfacesSizes.put("OnlineLibrary","545.0/744.0");
        interfacesSizes.put("QuizViewAdmin","563.0/711.0");
        interfacesSizes.put("QuizViewClient","606.0/616.0");
        interfacesSizes.put("ChatViewAdmin","568.0/812.0");
        interfacesSizes.put("ChatViewClient","482.0/812.0");
        interfacesSizes.put("AddQuizAdmin","645.0/692.0");
        interfacesSizes.put("UpdateQuizAdmin","645.0/692.0");
    }

    public void handlemenuclick(ActionEvent actionEvent) {
        String ch = actionEvent.getTarget().toString();
        String id = ch.substring(ch.indexOf("id=")+3,ch.indexOf(","));
        System.out.println(id);
        redirect(id);
    }

    public void redirect (String name){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Interfaces/"+name+".fxml"));
            Parent root = loader.load();
            Global.getPrimaryStage().getScene().setRoot(root);
            Global.getPrimaryStage().setHeight(getHeight(name));
            Global.getPrimaryStage().setWidth(getWidth(name));
        } catch (IOException e) {
            System.out.println("test"+e.getMessage());
        }
    }
    public double getHeight (String name){
        String height = interfacesSizes.get(name).split("/")[0];
        return Double.parseDouble(height);
    }
    public double getWidth (String name){
        String width = interfacesSizes.get(name).split("/")[1];
        return Double.parseDouble(width);
    }
}