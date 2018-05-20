/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

/**
* Entity class used to store data to relete tags with books.
* exentds form OneToMany object.
* @see OneToMany
* @author  Yago Auza
*/
public class BookTag extends OneToMany {
    
     /**
     * Base class constructor.
     * @param pId Book unique identiffier.
     */
    public BookTag(int pId){
        super(pId);
    }
    
    /**
     * Full class constructor.
     * @param pId Book identifier number.
     * @param pOtherID Tag identifier number.
     */
    public BookTag(int pId, int pOtherID){
        super(pId,pOtherID);
    }
}
