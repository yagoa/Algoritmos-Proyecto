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
public class Autor extends UcuBooksBaseEntity{
    //ATRIBUTOS
    private String mName;
    
     //PROPIEDADES
    /**
     * @return the mName
     */
    public String getName() {
        return mName;
    }

    /**
     * @param mName the mName to set
     */
    public void setName(String mName) {
        this.mName = mName;
    }
    
    //CONSTRUCTORS
    
    /**
     * Base class constructor.
     */
    public Autor(){}
}
