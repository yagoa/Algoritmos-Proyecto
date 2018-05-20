/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

/**
* Entity class used to store data to relete autors with books.
* exentds form OneToMany object.
* @see OneToMany
* @author  Yago Auza
*/
public class AutorBook extends OneToMany{
    
    /**
     * Base class constructor.
     * @param pId Autor identifier number.
     */
    public AutorBook(int pId){
        super(pId);
    }
    
    /**
     * Full class constructor.
     * @param pId Autor unique identifier.
     * @param pOtherID Book unique identifier.
     */
    public AutorBook(int pId, int pOtherID){
        super(pId,pOtherID);
    }
}
