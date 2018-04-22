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
public class Tag extends UcuBooksBaseEntity {
    //ATRIBUTOS
    private String mTagName;
    
     //PROPIEDADES
    /**
     * @return the TagName
     */
    public String getTagName() {
        return mTagName;
    }

    /**
     * @param pTagName the mName to set
     */
    public void setTagName(String pTagName) {
        this.mTagName = pTagName;
    }
    
    //CONSTRUCTORS   
    /**
     * Base class constructor.
     */
    public Tag(){}
    
    public Tag(int pId){
        super(pId);
    }
}
