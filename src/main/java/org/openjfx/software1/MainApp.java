package org.openjfx.software1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainScreen.fxml"));
        
        Scene scene = new Scene(root);

        SceneController.setMain(scene);
        SceneController.addScene("main", FXMLLoader.load(getClass().getResource("/fxml/MainScreen.fxml")));
        SceneController.addScene("addPart", FXMLLoader.load(getClass().getResource( "/fxml/AddPart.fxml" )));
        SceneController.addScene("addProduct", FXMLLoader.load(getClass().getResource( "/fxml/AddProduct.fxml" )));
        
        stage.setTitle("Inventory Management");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
