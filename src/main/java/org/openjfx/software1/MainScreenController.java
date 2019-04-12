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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author neal
 */
public class MainScreenController implements Initializable {
    @FXML private TableView<Product> products;
    @FXML private TableColumn<Product, String> productID;
    @FXML private TableColumn<Product, String> productName;
    @FXML private TableColumn<Product, String> productInventory;
    @FXML private TableColumn<Product, String> productPrice;
    
    @FXML private TableView<Part> parts;
    @FXML private TableColumn<Part, String> partID;
    @FXML private TableColumn<Part, String> partName;
    @FXML private TableColumn<Part, String> partInventory;
    @FXML private TableColumn<Part, String> partPrice;

    @FXML TextField searchParts;
    @FXML TextField searchProducts;
    
    @FXML private javafx.scene.control.Button exitButton;
    
    private Part getSelectedPart() {
        return parts.getSelectionModel().getSelectedItem();
    }

    private Product getSelectedProduct() {
        return products.getSelectionModel().getSelectedItem();
    }
    
    private void renderParts( ObservableList partItems ) {
        ObservableList items = partItems == null ? GlobalInventory.getTabulatedParts(null) : partItems;
        parts.setItems(items);
    }
    
    private void renderProducts(ObservableList productItems) {
        ObservableList items = productItems == null ? GlobalInventory.getTabulatedProducts(null) : productItems;
        products.setItems(items);
    }

    @FXML private void handlePartAdd(ActionEvent event) throws IOException {
        loadAddPart();
    }
    @FXML private void handlePartEdit(ActionEvent event) {
        Part part = getSelectedPart();
        if( part != null ){
            // TODO
        }
    }
    @FXML private void handlePartDelete(ActionEvent event) {
        Part part = getSelectedPart();
        if( part != null ){
            GlobalInventory
                .get()
                .deletePart( part.getPartID() );
            
            renderParts(null);
        }
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
    @FXML private void handleProductAdd(ActionEvent event) throws IOException {
        loadAddProduct();
    }
    @FXML private void handleProductEdit(ActionEvent event) {
        // TODO
    }
    @FXML private void handleProductDelete(ActionEvent event) {
        Product product = getSelectedProduct();
        if( product != null ){
            GlobalInventory
                .get()
                .deleteProduct( product.getProductID() );
            
            renderProducts(null);
        }
    }
    @FXML private void handleProductSearch(ActionEvent event) {
        String text = searchProducts.getText();
        if( text != null && !text.isEmpty() ) {
            ArrayList<Product> currentProducts = GlobalInventory.getProducts();
            ArrayList<Product> results = new ArrayList<Product>();
            
            for (Product product : currentProducts) {
                if( product.getName().contains(text) ){
                    results.add(product);
                }
            }
            
            renderProducts( GlobalInventory.getTabulatedProducts(results) );
        } else {
            renderProducts(null);
        }
    }
    
    @FXML private void handleExit(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML private void loadAddPart() throws IOException {
        SceneController.load(FXMLLoader.load(getClass().getResource( "/fxml/AddPart.fxml" )));
    }
    
    @FXML private void loadAddProduct() throws IOException {
        SceneController.load(FXMLLoader.load(getClass().getResource( "/fxml/AddProduct.fxml" )));
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
        renderProducts(null);
        
        partID.setCellValueFactory(new PropertyValueFactory<Part, String>("partID"));
        partName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        partInventory.setCellValueFactory(new PropertyValueFactory<Part, String>("inStock"));
        partPrice.setCellValueFactory(new PropertyValueFactory<Part, String>("price"));
        renderParts(null);
    }    
    
}
