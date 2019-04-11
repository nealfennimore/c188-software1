/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.software1;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.ObservableList;

/**
 *
 * @author neal
 */
public class GlobalInventory {
   private static Inventory self = new Inventory(
        new ArrayList<Product>(
            Arrays.asList(
                new Product()
            )
        ),
        new ArrayList<Part>(
            Arrays.asList(
                new InHouse(),
                new Outsourced()
            )
        )
   );
   public static Inventory get() { return self; } 
   public static ArrayList<Product> getProducts() { 
      return self.getProducts();
   }
   public static ArrayList<Part> getParts() { 
      return self.getAllParts();
   }
   public static ObservableList getTabulatedProducts() { 
      return self.getTabulatedProducts();
   }
   public static ObservableList getTabulatedParts() { 
      return self.getTabulatedParts();
   }
}
