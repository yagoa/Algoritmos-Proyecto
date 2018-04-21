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
    public String getmName() {
        return mName;
    }

    /**
     * @param mName the mName to set
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    /**
     * @return the mYear
     */
    public short getmYear() {
        return mYear;
    }

    /**
     * @param mYear the mYear to set
     */
    public void setmYear(short mYear) {
        this.mYear = mYear;
    }

    /**
     * @return the mPoints
     */
    public float getmPoints() {
        return mPoints;
    }

    /**
     * @param mPoints the mPoints to set
     */
    public void setmPoints(float mPoints) {
        this.mPoints = mPoints;
    }

    /**
     * @return the mCantPoints
     */
    public int getmCantPoints() {
        return mCantPoints;
    }

    /**
     * @param mCantPoints the mCantPoints to set
     */
    public void setmCantPoints(int mCantPoints) {
        this.mCantPoints = mCantPoints;
    }

    /**
     * @return the mISBN
     */
    public String getmISBN() {
        return mISBN;
    }

    /**
     * @param mISBN the mISBN to set
     */
    public void setmISBN(String mISBN) {
        this.mISBN = mISBN;
    }
    
    //CONSTRUCTORS
    /**
     * Base class constructor.
     */
    public Book(){}
}
