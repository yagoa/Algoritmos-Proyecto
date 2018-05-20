/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicAccesLayer;

import DataAccesLayer.Repository;
import Entitys.*;
import Utils.Collections.Lists.*;
import java.io.IOException;

/**
 * Provide a set of methods and functions to perforrm all search releted to books
 * @author Yago Auza
 */
public class Search {
    
    private final Repository BooksRepo;
    private final Repository TagsRepo;
    private final Repository AutorsRepo;
    private final Repository AutorBooksRepo;
    private final Repository BookTagsRepo;
    
    /**
     * Base class constructor.
     * @param pBooksRepo book repository instance
     * @param pTagsRepo tags repository instance
     * @param pAutorsRepo autors repository instance
     * @param pAutorBooksRepo autors books repository instance
     * @param pBookTagsRepo books tags repository instance
     */
    public Search(Repository pBooksRepo,Repository pTagsRepo,Repository pAutorsRepo,Repository pAutorBooksRepo,Repository pBookTagsRepo ){
        this.TagsRepo = pTagsRepo;
        this.AutorsRepo = pAutorsRepo;
        this.BooksRepo = pBooksRepo;
        this.AutorBooksRepo = pAutorBooksRepo;
        this.BookTagsRepo = pBookTagsRepo;
    }
    
    /**
     * Get a list of books from a certain year of publication.
     * @param pYear book year
     * @return List of books
     * @see Book
     * @see IOException
     * @see IList
     * @throws IOException
     */
    public IList<Book> BooksByYear(short pYear) throws IOException{
       
        IList lResult = new List<>();
        IList<Book> lSource = BooksRepo.getAll();
  
        if (lSource.isEmpty())
            return lResult;
        
        for(INode<Book> lNode = lSource.getFirst(); lNode != null; lNode = lNode.getNext()){       
            
            Book lCurrent = lNode.getData();
            if(lCurrent.getYear() >= pYear){          
                lResult.add(new Node<>(lCurrent,lCurrent.getID()));
            }  
        }   
            
       return lResult;
    }
    
    /**
     * Get a list of books from a certain autor.
     * @param pAutorName autor name
     * @return List of books writen by the autor
     * @see Book
     * @see IOException
     * @see IList
     * @throws IOException
     */
    public IList<Book> BooksByAutor(String pAutorName) throws IOException{
        IList lResult = new List<>();
        
        if(pAutorName == null || pAutorName.equals(""))
            return lResult;     
        
        IList<Book> lSource = BooksRepo.getAll();
        
        if (lSource.isEmpty())
            return lResult;
        
        for(INode<Book> lNode = lSource.getFirst(); lNode != null; lNode = lNode.getNext()){ 
            
            Book lCurrentBook = lNode.getData();
            if(lCurrentBook.getAutors() != null && lCurrentBook.getAutors().size() > 0) {           
                IList<Autor> lAutors = lCurrentBook.getAutors();
                
                for(INode<Autor> lNodeAutor = lAutors.getFirst(); lNodeAutor != null; lNodeAutor = lNodeAutor.getNext()){               
                    Autor lCurrentAutor = lNodeAutor.getData();
                   
                    if(lCurrentAutor.getName().toLowerCase().equals(pAutorName.toLowerCase())){         
                        System.out.println(lCurrentBook.toString());            
                        lResult.add(new Node<>(lCurrentBook,lCurrentBook.getID()));
                    }
                }
            }     
        }    
        return lResult;
    }
    
    /**
     * Get a list of books from a by a tag.
     * @param pTag tag name
     * @return List of books releted withe the tag
     * @see Book
     * @see IOException
     * @see IList
     * @see Tag
     * @throws IOException
     */
    public IList<Book> BooksByTag(String pTag) throws IOException{
        
        IList lResult = new List<>();   
        if(pTag == null || pTag.equals(""))
            return lResult;
        
        IList<Book> lSource = BooksRepo.getAll();
        if (lSource.isEmpty())
             return lResult;
           
        for(INode<Book> lNode = lSource.getFirst(); lNode != null; lNode = lNode.getNext()){ 
            
            Book lCurrentBook = lNode.getData();
            if(lCurrentBook.getTags() != null && lCurrentBook.getTags().size() > 0) {
                
                IList<Tag> lBookTags = lCurrentBook.getTags();
                
                for(INode<Tag> lNodeTag = lBookTags.getFirst(); lNodeTag != null; lNodeTag = lNodeTag.getNext()){ 
                    
                    Tag lCurrentTag = lNodeTag.getData();
                    if(lCurrentTag.getTagName().toLowerCase().equals(pTag.toLowerCase())){            
                        System.out.println(lCurrentBook.toString());
                        
                        lResult.add(new Node<>(lCurrentBook,lCurrentBook.getID()));
                    }
                }
            }     
        }    
        return lResult;
    }
    
    /**
     * Get a list of books by his name and his year of publication
     * @param pBookName book name
     * @param pYear year of publication
     * @return List of books 
     * @see Book
     * @see IOException
     * @see IList
     * @throws IOException
     */
    public IList<Book> BookByNameAndYear(String pBookName, short pYear) throws IOException{
        
        IList<Book> lSource = this.BooksByYear(pYear);
        IList lResult = new List<>();
        if (lSource.isEmpty())
             return lResult;
                
        for(INode<Book> lNode = lSource.getFirst(); lNode != null; lNode = lNode.getNext()){
            
            Book lCurrent = lNode.getData();

            String lName = lCurrent.getName() == null ? "" : lCurrent.getName().toLowerCase();
            short lYear = lCurrent.getYear();
            
            if(lYear == pYear && lName.equals(pBookName.toLowerCase())){             
                System.out.println(lCurrent.toString());             
                lResult.add(new Node<>(lCurrent,lCurrent.getID()));
            }  
        }
 
        return lResult;
    }
    
    /**
     * Get a list of books by the autor and a ISBN number
     * @param pAutorName autor name
     * @param pISBN ISBN can be ISBN or ISBN13
     * @return List of books 
     * @see Book
     * @see IOException
     * @see IList
     * @throws IOException
     */
    public IList<Book> BookByAutorAndISBN(String pAutorName, String pISBN) throws IOException{
        
        IList lResult = new List<>();
        IList<Book> lSource = this.BooksByAutor(pAutorName);
        if (lSource.isEmpty())
            return lResult;
             
        for(INode<Book> lNode = lSource.getFirst(); lNode != null; lNode = lNode.getNext()){
            
            Book lCurrentBook = lNode.getData();
            
            String lISBNBoth = lCurrentBook.getISBN() != null ? lCurrentBook.getISBN() : "/";
            String[] lISBN = lISBNBoth.split("/");
            
            if(lISBN.length != 0 && (lISBN[0].equals(pISBN) || lISBN[1].equals(pISBN))){
                System.out.println(lCurrentBook.toString());
                lResult.add(new Node<>(lCurrentBook,lCurrentBook.getID()));      
            }
        }     
        return lResult;
    }   
}
