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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author neal
 */
public class MainScreenController implements Initializable {
    @FXML
    private TableView<Product> products;
    @FXML
    private TableColumn<Product, String> productID;
    @FXML
    private TableColumn<Product, String> productName;
    @FXML
    private TableColumn<Product, String> productInventory;
    @FXML
    private TableColumn<Product, String> productPrice;
    
    @FXML
    private TableView<Part> parts;
    @FXML
    private TableColumn<Part, String> partID;
    @FXML
    private TableColumn<Part, String> partName;
    @FXML
    private TableColumn<Part, String> partInventory;
    @FXML
    private TableColumn<Part, String> partPrice;
    


    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productID.setCellValueFactory(new PropertyValueFactory<Product, String>("productID"));
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        productInventory.setCellValueFactory(new PropertyValueFactory<Product, String>("inStock"));
        productPrice.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));
        products.setItems(GlobalInventory.getTabulatedProducts());
        
        partID.setCellValueFactory(new PropertyValueFactory<Part, String>("partID"));
        partName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        partInventory.setCellValueFactory(new PropertyValueFactory<Part, String>("inStock"));
        partPrice.setCellValueFactory(new PropertyValueFactory<Part, String>("price"));
        parts.setItems(GlobalInventory.getTabulatedParts());
    }    
    
}
