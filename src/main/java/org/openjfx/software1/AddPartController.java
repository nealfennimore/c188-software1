/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.software1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author neal
 */
public class AddPartController implements Initializable {  
    
    @FXML ToggleGroup partType; //I called it right in SceneBuilder.
    @FXML TextField name;
    @FXML TextField stock;
    @FXML TextField price;
    @FXML TextField max;
    @FXML TextField min;
    @FXML TextField machineID;

    private String getPartType() {
        RadioButton selectedRadioButton = (RadioButton) partType.getSelectedToggle();
        return selectedRadioButton.getText();
    }
    
    @FXML private void handleRadioToggle(ActionEvent event) {
        String type = getPartType();
        if ( type.contains("In-House") ){
            machineID.setEditable(true);
        } else {
            machineID.setEditable(false);
        }
    }
    
    @FXML private void handleSave(ActionEvent event) {
        String type = getPartType();

        if( type.contains("In-House") ){
            InHouse part = new InHouse(
                GlobalInventory.getParts().size() + 1,
                name.getText(),
                Double.parseDouble( price.getText() ),
                Integer.parseInt( stock.getText() ),
                Integer.parseInt( min.getText() ),
                Integer.parseInt( max.getText() ),
                Integer.parseInt( machineID.getText() )
            );
            GlobalInventory.get().addPart(part);
        } else {
           Outsourced part = new Outsourced(
                GlobalInventory.getParts().size() + 1,
                name.getText(),
                Double.parseDouble( price.getText() ),
                Integer.parseInt( stock.getText() ),
                Integer.parseInt( min.getText() ),
                Integer.parseInt( max.getText() ),
                "Company"
           );
           GlobalInventory.get().addPart(part);
        }

        SceneController.activate("main");
    }
    
    @FXML private void handleCancel(ActionEvent event) {
        SceneController.activate("main");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
