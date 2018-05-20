/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

/**
* Entity class used to store data of for tags.
* exentds form UcuBooksBaseEntity object.
* @see UcuBooksBaseEntity
* @author  Yago Auza
*/
public class Tag extends UcuBooksBaseEntity {
    
    private String mTagName;
    
    /**
     * Get the current tag name
     * @return Tag name
     */
    public String getTagName() {
        return mTagName;
    }

    /**
     * Set the current tag name
     * @param pTagName tag name
     */
    public void setTagName(String pTagName) {
        this.mTagName = pTagName;
    }
    
    /**
     * Base class constructor.
     */
    public Tag(){}
    
    public Tag(int pId){
        super(pId);
    }
}
