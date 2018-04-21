/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

/**
* Abstract class used as base type for make entitys relations.
* @author  Yago Auza
* @version 1.0
 */
public abstract class OneToMany extends UcuBooksBaseEntity {
    private int mOtherID = 0;
    
    /**
     * Get the second entity unique identifier number.
     * @return Unique indetfier number.
     */
    public int getOtherID() {
        return this.mOtherID;
    }

    /**
     * Set the second entity unique identifier number.
     * @param otherID 
     */
    public void setOtherID(int otherID) {
        this.mOtherID = otherID;
    }
    
    public OneToMany(int pId){
        this.setID(pId);
    }   
      
    public OneToMany(int pId, int pOtherID){
        this.setID(pId);
        this.mOtherID = pOtherID;
    }
}
