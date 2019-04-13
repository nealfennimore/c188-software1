/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.software1;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author neal
 */
public class AddProductController implements Initializable {  

    @FXML TextField name;
    @FXML TextField stock;
    @FXML TextField price;
    @FXML TextField max;
    @FXML TextField min;
    
    @FXML TextField searchParts;
    
    @FXML private TableView<Part> parts;
    @FXML private TableColumn<Part, String> partID;
    @FXML private TableColumn<Part, String> partName;
    @FXML private TableColumn<Part, String> partInventory;
    @FXML private TableColumn<Part, String> partPrice;

    @FXML private TableView<Part> productParts;
    @FXML private TableColumn<Part, String> productPartID;
    @FXML private TableColumn<Part, String> productPartName;
    @FXML private TableColumn<Part, String> productPartInventory;
    @FXML private TableColumn<Part, String> productPartPrice;
    
    private ArrayList<Part> productPartsList = new ArrayList<>();
    
    private Part getSelectedPart() {
        return parts.getSelectionModel().getSelectedItem();
    }

    private Part getSelectedProductPart() {
        return productParts.getSelectionModel().getSelectedItem();
    }

    private void renderParts( ObservableList partItems ) {
        ObservableList items = partItems == null ? GlobalInventory.getTabulatedParts(null) : partItems;
        parts.setItems(items);
    }
    
    private void renderSelectedParts() {
        ObservableList items = FXCollections.observableArrayList( productPartsList );
        productParts.setItems(items);
    }
    
    @FXML private void handlePartSearch(ActionEvent event) {
        String text = searchParts.getText();
        if( text != null && !text.isEmpty() ) {
            ArrayList<Part> currentParts = GlobalInventory.getParts();
            ArrayList<Part> results = new ArrayList<Part>();
            
            for (Part part : currentParts) {
                if( part.getName().contains(text) ){
                    results.add(part);
                }
            }
            
            renderParts( GlobalInventory.getTabulatedParts(results) );
        } else {
            renderParts(null);
        }
    }

    @FXML private void handlePartAdd(ActionEvent event) {
        Part part = getSelectedPart();
        if ( part != null && ! productPartsList.contains(part) ) {
            productPartsList.add(part);
            renderSelectedParts();
        }
    }

    @FXML private void handlePartDelete(ActionEvent event) {
        Part part = getSelectedProductPart();
        if (part != null) {
            productPartsList.remove(part);
            renderSelectedParts();
        }
    }
    
    @FXML private void handleSave(ActionEvent event) throws IOException {
        if( productPartsList.size() > 0 ){
            Product product = new Product(
                GlobalInventory.getProducts().size() + 1,
                name.getText(),
                Double.parseDouble( price.getText() ),
                Integer.parseInt( stock.getText() ),
                Integer.parseInt( min.getText() ),
                Integer.parseInt( max.getText() ),
                productPartsList
            );

            GlobalInventory.get().addProduct(product);

            loadMainScreen();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please add a part to the product.");

            alert.showAndWait();
        }
    }
    
    @FXML private void handleCancel(ActionEvent event) throws IOException {
        loadMainScreen();
    }

    @FXML private void loadMainScreen() throws IOException {
        SceneController.load(FXMLLoader.load(getClass().getResource( "/fxml/MainScreen.fxml" )));
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partID.setCellValueFactory(new PropertyValueFactory<Part, String>("partID"));
        partName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        partInventory.setCellValueFactory(new PropertyValueFactory<Part, String>("inStock"));
        partPrice.setCellValueFactory(new PropertyValueFactory<Part, String>("price"));
        renderParts(null);
        
        productPartID.setCellValueFactory(new PropertyValueFactory<Part, String>("partID"));
        productPartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        productPartInventory.setCellValueFactory(new PropertyValueFactory<Part, String>("inStock"));
        productPartPrice.setCellValueFactory(new PropertyValueFactory<Part, String>("price"));
        renderSelectedParts();
    }
}
