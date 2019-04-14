/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software2;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.ObservableList;

/**
 *
 * @author neal
 */
public class GlobalInventory {  
   private static Inventory self = new Inventory(
        new ArrayList<Product>(),
        new ArrayList<Part>(
            Arrays.asList(
                new InHouse(),
                new Outsourced()
            )
        )
   );

   private static Part activePart;
   private static Product activeProduct;

   /**
    * @param activePart the activePart to set
    */
   public static void setActivePart(Part activePart) {
      GlobalInventory.activePart = activePart;
   }
   
   /**
    * @return the activePart
    */
   public static Part getActivePart() {
      return activePart;
   }

   /**
    * @param activeProduct the activeProduct to set
    */
   public static void setActiveProduct(Product activeProduct) {
      GlobalInventory.activeProduct = activeProduct;
   }

   /**
    * @return the activeProduct
    */
   public static Product getActiveProduct() {
      return activeProduct;
   }

   public static Inventory get() { return self; } 
   public static ArrayList<Product> getProducts() { 
      return self.getProducts();
   }
   public static ArrayList<Part> getParts() { 
      return self.getAllParts();
   }
   public static ObservableList getTabulatedProducts(ArrayList<Product> products) { 
      return self.getTabulatedProducts(products);
   }
   public static ObservableList getTabulatedParts(ArrayList<Part> parts) { 
      return self.getTabulatedParts(parts);
   }
}
