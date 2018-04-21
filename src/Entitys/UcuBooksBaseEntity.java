/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

/**
* Base object class for all entitys.
* @author  Yago Auza
* @version 1.0
 */

public class UcuBooksBaseEntity extends Object {
    //ATRIBUTOS
    private int mId;
    
    //PROPIEDADES
    
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
    
    //CONSTRUCTORES
    /**
     * Base class constructor.
     */
    public UcuBooksBaseEntity(){}
    
    
    /**
     * Full class constructor.
     * @param pId Unique identification number.
     */
    public UcuBooksBaseEntity(int pId)
    {
        this.mId = pId;
    }

    public boolean equals(UcuBooksBaseEntity pOther)
    {
        boolean lResult = false;
        
        if (pOther == null)
            lResult = false;
        
        if (pOther.getID() == this.mId) 
            lResult = true;
        
        return lResult;
    }
}
