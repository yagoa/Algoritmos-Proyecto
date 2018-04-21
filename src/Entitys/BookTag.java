/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

/**
 *
 * @author yago
 */
public class BookTag extends OneToMany {
    
         /**
     * Base class constructor.
     * @param pOtherID Actor identifier number.
     */
    public BookTag(int pId){
        super(pId);
    }
    
    /**
     * Full class constructor.
     * @param pID Movie identifier number.
     * @param pOtherID Actor identifier number.
     */
    public BookTag(int pId, int pOtherID){
        super(pId,pOtherID);
    }
}
