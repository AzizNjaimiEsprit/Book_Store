package Utility;

import Beans.User;
import javafx.stage.Stage;

public class Global {
    private static User currentUser = new User(1);
    private static Stage primaryStage;

   // ************************* Getter & Setter ****************************

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Global.currentUser = currentUser;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Global.primaryStage = primaryStage;
    }

}
