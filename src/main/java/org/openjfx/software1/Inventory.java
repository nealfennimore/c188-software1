/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.software1;

import java.util.ArrayList;

/**
 *
 * @author neal
 */
public class Inventory {

    private ArrayList<Product> products;
    private ArrayList<Part> allParts;

    public Inventory( ArrayList<Product> products, ArrayList<Part> allParts) {
        this.products = products;
        this.allParts = allParts;
    }

    /**
     * @param part the part to add
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * @param productID the productID to remove
     * @return Boolean
     */
    public boolean deleteProduct(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                return products.remove(product);
            }
        }
        return false;
    }

    /**
     * @return Product
     */
    public Product lookupProduct(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null;
    }
    /**
     * @param productID
     */
    public void updateProduct(int productID) {
    }

    /**
     * @param part the part to add
     */
    public void addPart(Part part) {
        allParts.add(part);
    }

    /**
     * @param partID the partID to remove
     * @return Boolean
     */
    public boolean deletePart(int partID) {
        for (Part part : allParts) {
            if (part.getPartID() == partID) {
                return allParts.remove(part);
            }
        }
        return false;
    }

    /**
     * @return Part
     */
    public Part lookupPart(int partID) {
        for (Part part : allParts) {
            if (part.getPartID() == partID) {
                return part;
            }
        }
        return null;
    }
    /**
     * @param partID
     */
    public void updatePart(int partID) {
    }

}
