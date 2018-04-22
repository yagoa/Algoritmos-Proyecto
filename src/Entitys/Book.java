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
public class Book extends UcuBooksBaseEntity {

    //ATRIBUTOS
    private String mName;
    private short mYear;
    private float mPoints;
    private int mCantPoints;
    private String mISBN;



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

    /**
     * @return the mYear
     */
    public short getYear() {
        return mYear;
    }

    /**
     * @param mYear the mYear to set
     */
    public void setYear(short mYear) {
        this.mYear = mYear;
    }

    /**
     * @return the mPoints
     */
    public float getPoints() {
        return mPoints;
    }

    /**
     * @param mPoints the mPoints to set
     */
    public void setPoints(float mPoints) {
        this.mPoints = mPoints;
    }

    /**
     * @return the mCantPoints
     */
    public int getCantPoints() {
        return mCantPoints;
    }

    /**
     * @param mCantPoints the mCantPoints to set
     */
    public void setCantPoints(int mCantPoints) {
        this.mCantPoints = mCantPoints;
    }

    /**
     * @return the mISBN
     */
    public String getISBN() {
        return mISBN;
    }

    /**
     * @param mISBN the mISBN to set
     */
    public void setISBN(String mISBN) {
        this.mISBN = mISBN;
    }
    
    //CONSTRUCTORS
    /**
     * Base class constructor.
     */
    public Book(){}
    
    public Book(int pId){
        super(pId);
    }
}
