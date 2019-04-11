/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.software1;

/**
 *
 * @author neal
 */
public class Outsourced extends Part {

    private String companyName;
    
    public Outsourced(){
        this(2, "Outsourced Part", 1.00, 1, 1, 10, "Company" );
    }
    
    public Outsourced( int partID, String name, double price, int inStock, int min, int max, String companyName ) {
        super(partID, name, price, inStock, min, max);
        setCompanyName(companyName);
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }
}
