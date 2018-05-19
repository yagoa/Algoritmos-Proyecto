/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.INode;
import Utils.Collections.Lists.List;
import Utils.Collections.Lists.Node;

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
    private IList<Autor> mAutors;
    private IList<Tag> mTags;


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
    
    public IList<Autor> getAutors() {
        return mAutors;
    }
    
    public void setAutors(IList<Autor> mAutors) {
        this.mAutors = mAutors;
    }

    public IList<Tag> getTags() {
        return mTags;
    }

    public void setTags(IList<Tag> mTags) {
        this.mTags = mTags;
    }
    
    //CONSTRUCTORS
    /**
     * Base class constructor.
     */
    public Book(){}
    
    public Book(int pId){
        super(pId);
    }
    
    //METODOS
    public void addAutor(Autor pAutor) throws NullPointerException
    {
        if(pAutor != null){
            if(this.getAutors() == null){
                this.mAutors = new List<Autor>();
            }

            if(this.mAutors.search(pAutor.getID()) == null){
                INode lNewNode = new Node(pAutor, pAutor.getID());
                this.mAutors.add(lNewNode);
            }
        }
        else
            throw new NullPointerException("Producers can't be null."); 
    }
    
    public void addTag(Tag pTag) throws NullPointerException
    {
        if(pTag != null){
            if(this.getTags() == null){
                this.mTags = new List<Tag>();
            }

            if(this.mTags.search(pTag.getID()) == null){
                INode lNewNode = new Node(pTag, pTag.getID());
                this.mTags.add(lNewNode);
            }
        }
        else
            throw new NullPointerException("Producers can't be null."); 
    }
    
    @Override
    public String toString() {
        return this.mName+"/"+ this.mYear;
    }
}
