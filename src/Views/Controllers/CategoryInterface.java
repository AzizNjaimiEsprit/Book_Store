package Views.Controllers;

import Beans.Category;
import Beans.User;
import Services.*;
import Utils.Global;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.*;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class CategoryInterface implements Initializable {


    @FXML
    private ImageView IdLigo;


    @FXML
    private TableView<Category> tableview_Category;

    @FXML
    private TableColumn<Category, String> category;

    ObservableList<Category> list = FXCollections.observableArrayList();
    ServiceCategorie sg = new ServiceCategorie ();
    User connectedUser = Global.getCurrentUser();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(sg.afficher());
        list = sg.afficher();
        category.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableview_Category.setItems(list);
        prepareSlideMenuAnimation();

    }

    private void prepareSlideMenuAnimation() {
        TranslateTransition openNav=new TranslateTransition(new javafx.util.Duration(4350), IdLigo);
        openNav.setToX(0);
        openNav.play();
        TranslateTransition closeNav=new TranslateTransition(new Duration(4350), IdLigo);


        if(IdLigo.getTranslateX()!=0) {
            openNav.play();
        }
            else{
                closeNav.setToX(-90);
                closeNav.play();
            }

    }

    public void addCategory(ActionEvent actionEvent) {
        try{
            String name;
            do{
                 name = JOptionPane.showInputDialog(null, "Please Enter the category name");

                 if(name.matches("[0-9]+") ){
                     Alert alert = new Alert(Alert.AlertType.WARNING, "Category name must be a string", ButtonType.OK);
                     alert.show();
                     return;
                 }

               if( name.length()>1 ) {
                   int res = JOptionPane.showConfirmDialog(null, "Would you like to add this category?", "Confirmation", JOptionPane.YES_NO_OPTION);
                   if (res == JOptionPane.YES_OPTION) {
                       Category c = new Category(name);
                       sg.ajouter(c);
                       list.add(c);
                       tableview_Category.setItems(list);
                       tableview_Category.refresh();


                   }
               }
               }while(name.length()<1);

            final String fromEmail = "wafaha36@gmail.com"; //requires valid gmail id
            final String password = "S.trength"; // correct password for gmail id
            final String toEmail = "wafa.hammami@esprit.tn"; // can be any email id

            System.out.println("SSLEmail Start");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
            props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
            props.put("mail.smtp.port", "465"); //SMTP Port

            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };

            Session session = Session.getDefaultInstance(props, auth);
            System.out.println("Session created");
            EmailUtil.sendEmail(session, toEmail,"NWMSH_BookStore", "New category has been added");
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Mail envoyé", ButtonType.OK);
            alert.show();
            prepareSlideMenuAnimation();



        }catch(Exception ex){
            System.out.println(ex.getMessage());
            
        }

    }

    public void update(ActionEvent actionEvent) {

            String name = JOptionPane.showInputDialog(null, "Enter new name");
        if(name.matches("[0-9]+") ){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Category name must be a string", ButtonType.OK);
            alert.show();
            return;
        }
            try {

                if (name.length()<1) {
                    JOptionPane.showMessageDialog(null, "Invalide name");
                    return;

                }
                int res = JOptionPane.showConfirmDialog(null, "Would you like to save update?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    tableview_Category.getSelectionModel().getSelectedItem().setName(name);
                    tableview_Category.refresh();
                    System.out.println(tableview_Category.getSelectionModel().getSelectedItem());


                    sg.modifier(tableview_Category.getSelectionModel().getSelectedItem());
                    prepareSlideMenuAnimation();
                }
            } catch (Exception ex) {
                System.out.println("Invalide name");
            }


    }

    public static class TestInterface {
    }
}
