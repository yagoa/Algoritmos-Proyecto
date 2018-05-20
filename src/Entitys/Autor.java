/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

/**
* Entity class used to store data of a autor.
* exentds form UcuBooksBaseEntity object.
* @see UcuBooksBaseEntity
* @author  Yago Auza
*/
public class Autor extends UcuBooksBaseEntity{
    private String mName;
    
    /**
     * Get the autor name
     * @return autor name
     */
    public String getName() {
        return mName;
    }

    /**
     * set the autor name 
     * @param mName autor name
     */
    public void setName(String mName) {
        this.mName = mName;
    }
    
    
    /**
     * Base class constructor.
     */
    public Autor(){}

    /**
     * Base class constructor.
     */
    public Autor(int pId){
        super(pId);
    }
}
