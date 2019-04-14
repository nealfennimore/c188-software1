/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software2;

import java.util.ArrayList;

/**
 *
 * @author neal
 */
public class InHouse extends Part {
    
    private int machineID;
    
    public InHouse(){
        this(1, "Inhouse Part", 1.00, 1, 1, 10, 1 );
    }

    public InHouse( int partID, String name, double price, int inStock, int min, int max, int machineID ){
        super(partID, name, price, inStock, min, max);
        setMachineID(machineID);
    }

    /**
     * @param machineID the machineID to set
     */
    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }

    /**
     * @return the machineID
     */
    public int getMachineID() {
        return machineID;
    }
}
