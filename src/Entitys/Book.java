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
* Entity class used to store data of books.
* exentds form UcuBooksBaseEntity object.
* @see UcuBooksBaseEntity
* @author  Yago Auza
*/
public class Book extends UcuBooksBaseEntity {

    private String mName;
    private short mYear;
    private float mPoints;
    private int mCantPoints;
    private String mISBN;
    private IList<Autor> mAutors;
    private IList<Tag> mTags;

    /**
     * Get the book name
     * @return book name
     */
    public String getName() {
        return mName;
    }

    /**
     * Set the book name
     * @param mName book name
     */
    public void setName(String mName) {
        this.mName = mName;
    }

    /**
     * Get the book year of publication
     * @return book year of publication
     */
    public short getYear() {
        return mYear;
    }

    /**
     * Set the book year of publication
     * @param mYear book year of publication
     */
    public void setYear(short mYear) {
        this.mYear = mYear;
    }

    /**
     * Get the book points
     * @return book points
     */
    public float getPoints() {
        return mPoints;
    }

    /**
     * Set the book points
     * @param mPoints book points
     */
    public void setPoints(float mPoints) {
        this.mPoints = mPoints;
    }

    /**
     * Get the book quantity of points 
     * @return book quantity of points 
     */
    public int getCantPoints() {
        return mCantPoints;
    }

    /**
     * Set the book quantity of points 
     * @param mCantPoints book quantity of points 
     */
    public void setCantPoints(int mCantPoints) {
        this.mCantPoints = mCantPoints;
    }

    /**
     * Set the book ISBM
     * @return book ISBN
     */
    public String getISBN() {
        return mISBN;
    }

    /**
     * Get the book ISBN
     * @param mISBN book ISBN
     */
    public void setISBN(String mISBN) {
        this.mISBN = mISBN;
    }
    
    /**
     * Get a list withe the book autors or null
     * @see Autor
     * @return List of autors
     */
    public IList<Autor> getAutors() {
        return mAutors;
    }
    
    /**
     * Set a list withe the book autors
     * @see Autor
     * @param mAutors book releted autors
     */
    public void setAutors(IList<Autor> mAutors) {
        this.mAutors = mAutors;
    }

    /**
     * Get a list withe the book releted tags or null
     * @see Tag
     * @return List of tags
     */
    public IList<Tag> getTags() {
        return mTags;
    }

    /**
     * Set a list withe the book releted tags
     * @see Tag
     * @param mAutors list of releted tags for the book
     */
    public void setTags(IList<Tag> mTags) {
        this.mTags = mTags;
    }
    
    /**
     * Base class constructor.
     */
    public Book(){}
    
    public Book(int pId){
        super(pId);
    }
    
    /**
     * Add a new autor to relete him with the book
     * @param pAutor
     * @throws NullPointerException
     * @see Autor
     * @see NullPointerException
     */
    public void addAutor(Autor pAutor) throws NullPointerException{
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
    
    /**
     * Add a new tag to relete him with the book
     * @param Tag
     * @throws NullPointerException
     * @see Tag
     * @see NullPointerException
     */
    public void addTag(Tag pTag) throws NullPointerException{
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
        StringBuilder lSB = new StringBuilder();
        
        lSB.append("Id: ").append(this.getID());
        lSB.append("\n");
        lSB.append("Titulo: ").append((this.mName != null && !this.mName.equals("")) ? this.mName : "Desconocido");
        lSB.append("\n");
        lSB.append("ISBN/ISBN13: ").append((this.mISBN != null && !this.mISBN.equals("")) ? this.mISBN : "Desconocido");
        lSB.append("\n");
        lSB.append("Publicacion: ").append(this.mYear != 0 ? this.mYear : "Desconocido");
        lSB.append("\n"); 
        lSB.append("Puntaje: ").append(this.mPoints != 0 ? this.mPoints : "Desconocido");
        lSB.append("\n");
        lSB.append("Cantidad de puntaje: ").append(this.mCantPoints != 0 ? this.mCantPoints : "Desconocido");
        return lSB.toString();
    }
}
