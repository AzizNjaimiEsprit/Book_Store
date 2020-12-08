package Views.Controllers;


import Utilitaire.Global;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MenuBarController {
    public Map<String,String> interfacesSizes =  new HashMap<>();

    public MenuBarController() {
        interfacesSizes.put("AddOnlineBook","921/1305");
        interfacesSizes.put("Book","837/988");
       // interfacesSizes.put("Home","921/1305");
        interfacesSizes.put("HomeByAziz","965/1330");
        interfacesSizes.put("UpdateBook","837/988");
       /* interfacesSizes.put("ClientOrdersListPage","837/1598");
        interfacesSizes.put("OrdersListPage","869/1598");
        interfacesSizes.put("PaymentPage","584/712");
        interfacesSizes.put("EditOrderPage","730/896");*/
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
            e.printStackTrace();
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
