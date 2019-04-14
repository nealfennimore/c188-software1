/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software2;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author neal
 */
public class EditPartController implements Initializable {  
    
    @FXML ToggleGroup partType;
    @FXML RadioButton inhouse;
    @FXML RadioButton outsourced;
    @FXML TextField partID;
    @FXML TextField name;
    @FXML TextField stock;
    @FXML TextField price;
    @FXML TextField max;
    @FXML TextField min;
    @FXML TextField machineID;
    @FXML TextField company;
    
    @FXML HBox machineIDBox;
    @FXML HBox companyBox;

    private String getPartType() {
        RadioButton selectedRadioButton = (RadioButton) partType.getSelectedToggle();
        return selectedRadioButton.getText();
    }

    private String getPartID() {
        return partID.getText();
    }
    
    @FXML private void setPartTypeFieldVisibility(boolean isInHouse){
        if ( isInHouse ){
            machineIDBox.setVisible(true);
            companyBox.setVisible(false);
        } else {
            machineIDBox.setVisible(false);
            companyBox.setVisible(true  );
        }
    }

    @FXML private void handleRadioToggle(ActionEvent event) {
        String type = getPartType();
        setPartTypeFieldVisibility( type.contains("In-House") );
    }
    
    @FXML private void handleSave(ActionEvent event) throws IOException {
        String type = getPartType();
        int id = Integer.parseInt( getPartID() );

        if( type.contains("In-House") ){
            InHouse part = new InHouse(
                id,
                name.getText(),
                Double.parseDouble( price.getText() ),
                Integer.parseInt( stock.getText() ),
                Integer.parseInt( min.getText() ),
                Integer.parseInt( max.getText() ),
                Integer.parseInt( machineID.getText() )
            );
            GlobalInventory.get().updatePart(id, part);
        } else {
           Outsourced part = new Outsourced(
                id,
                name.getText(),
                Double.parseDouble( price.getText() ),
                Integer.parseInt( stock.getText() ),
                Integer.parseInt( min.getText() ),
                Integer.parseInt( max.getText() ),
                company.getText()
           );
            GlobalInventory.get().updatePart(id, part);
        }
        GlobalInventory.setActivePart(null);
        loadMainScreen();
    }
    
    @FXML private void handleCancel(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Leave this screen?");
        alert.setContentText("Any unsaved changes will be lost.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            GlobalInventory.setActivePart(null);
            loadMainScreen();
        }
    }

    @FXML private void loadMainScreen() throws IOException {
        SceneController.load(FXMLLoader.load(getClass().getResource( "MainScreen.fxml" )));
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Part part = GlobalInventory.getActivePart();
        boolean isInHouse = part instanceof InHouse;
        
        partID.setText( Integer.toString( part.getPartID() ));
        name.setText( part.getName() );
        stock.setText( Integer.toString( part.getInStock() ));
        price.setText( Double.toString( part.getPrice() ));
        max.setText( Integer.toString( part.getMax() ));
        min.setText( Integer.toString( part.getMin() ));       
        
        if(isInHouse){
            machineID.setText( Integer.toString( ((InHouse)part).getMachineID() ));
            inhouse.setSelected(true);
        } else {
            company.setText( ((Outsourced)part).getCompanyName() );
            outsourced.setSelected(true);
        }
        
        setPartTypeFieldVisibility(isInHouse);
    }
}
