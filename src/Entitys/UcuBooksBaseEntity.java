/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

/**
* Base object class for all entitys.
* @author  Yago Auza
 */

public class UcuBooksBaseEntity extends Object {
    private int mId;
    
    
    /**
     * Get the unique identification number.
     * @return Unique identification number.
     */
    public int getID() {
        return this.mId;
    }
    
    /**
     * Set the unique identification number.
     * @param pId Unique identification number.
     */
    public void setID(int pId) {
        this.mId = pId;
    }
    
    /**
     * Base class constructor.
     */
    public UcuBooksBaseEntity(){}
    
    /**
     * Full class constructor.
     * @param pId Unique identification number.
     */
    public UcuBooksBaseEntity(int pId){
        this.mId = pId;
    }
    
    public boolean equals(UcuBooksBaseEntity pOther){
        boolean lResult = false;
        
        if (pOther == null)
            lResult = false;
        
        if (pOther.getID() == this.mId) 
            lResult = true;
        
        return lResult;
    }
}
