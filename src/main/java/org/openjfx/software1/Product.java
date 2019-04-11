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
public class Product {

    private int productID;
    private String name;
    private double price;
    private int inStock;
    private int min;
    private int max;
    private ArrayList<Part> associatedParts;

    public Product(int productID, String name, double price, int inStock, int min, int max, ArrayList<Part> associatedParts) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.min = min;
        this.max = max;
        this.associatedParts = associatedParts;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param inStock the inStock to set
     */
    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    /**
     * @return the inStock
     */
    public int getInStock() {
        return inStock;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }


    /**
     * @param part the part to add
     */
    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }

    /**
     * @return Part
     */
    public Part lookupAssociatedPart(int partID) {
        for (Part part : associatedParts) {
            if( part.getPartID() == partID ){
                return part;
            }
        }
        return null;
    }

    /**
     * @param partID the partID to remove
     * @return Boolean
     */
    public boolean removeAssociatedPart(int partID) {
        for (Part part : associatedParts) {
            if (part.getPartID() == partID) {
                return associatedParts.remove( part );
            }
        }
        return false;
    }
}
