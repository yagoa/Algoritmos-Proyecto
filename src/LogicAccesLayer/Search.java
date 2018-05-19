/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicAccesLayer;

import DataAccesLayer.Repository;
import Entitys.*;
import Utils.Collections.IIterable;
import Utils.Collections.Lists.*;

/**
 *
 * @author yago
 */
public class Search {
    
    private final Repository BooksRepo;
    private final Repository TagsRepo;
    private final Repository AutorsRepo;
    private final Repository AutorBooksRepo;
    private final Repository BookTagsRepo;
    
    public Search(Repository pBooksRepo,Repository pTagsRepo,Repository pAutorsRepo,Repository pAutorBooksRepo,Repository pBookTagsRepo )
    {
        this.TagsRepo = pTagsRepo;
        this.AutorsRepo = pAutorsRepo;
        this.BooksRepo = pBooksRepo;
        this.AutorBooksRepo = pAutorBooksRepo;
        this.BookTagsRepo = pBookTagsRepo;
    }
    
    public IList<Book> BooksByYear(short pYear){
        IList<Book> lSource = BooksRepo.getAll();
  
        if (lSource.isEmpty()){ return null;}
       
        IList lResult = new List<Book>();
        
        IIterable<Book> lIterator = lSource.iterator();       
        while(lIterator.hasNext()){
            
            Book lCurrent = lIterator.next();
            if(lCurrent.getYear() >= pYear){
                
                System.out.println(lCurrent.toString());
                
                lResult.add(new Node<>(lCurrent,lCurrent.getID()));
            }  
        }   
        if (lResult.isEmpty()){ return null;}
       
       return lResult;
    }
    
    public IList<Book> BooksByAutor(String pAutorName){
        if(pAutorName == null || pAutorName == ""){return null;}
        
        IList<Book> lSource = BooksRepo.getAll();
        if (lSource.isEmpty()){ return null;}
       
        IList lResult = new List<Book>();
        
        IIterable<Book> lIteratorBooks = lSource.iterator();       
        while(lIteratorBooks.hasNext()){
            
            Book lCurrentBook = lIteratorBooks.next();
            if(lCurrentBook.getAutors() != null && lCurrentBook.getAutors().size() > 0) {
                
                IIterable<Autor> lIteratorAutor = lCurrentBook.getAutors().iterator();
                
                while(lIteratorAutor.hasNext()){
                    
                    Autor lCurrentAutor = lIteratorAutor.next();
                    if(lCurrentAutor.getName().toLowerCase().equals(pAutorName.toLowerCase())){
                        
                        System.out.println(lCurrentBook.toString());
                        
                        lResult.add(new Node<>(lCurrentBook,lCurrentBook.getID()));
                    }
                }
            }     
        }    
        return lResult;
    }
    
    public IList<Book> BooksByTag(String pTag){
        if(pTag == null || pTag == ""){return null;}
        
        IList<Book> lSource = BooksRepo.getAll();
        if (lSource.isEmpty()){ return null;}
       
        IList lResult = new List<Book>();
        
        IIterable<Book> lIteratorBooks = lSource.iterator();       
        while(lIteratorBooks.hasNext()){
            
            Book lCurrentBook = lIteratorBooks.next();
            if(lCurrentBook.getTags() != null && lCurrentBook.getTags().size() > 0) {
                
                IIterable<Tag> lIteratorTag = lCurrentBook.getTags().iterator();
                
                while(lIteratorTag.hasNext()){
                    
                    Tag lCurrentTag = lIteratorTag.next();
                    if(lCurrentTag.getTagName().toLowerCase().equals(pTag.toLowerCase())){
                        
                        System.out.println(lCurrentBook.toString());
                        
                        lResult.add(new Node<>(lCurrentBook,lCurrentBook.getID()));
                    }
                }
            }     
        }    
        return lResult;
    }
    
    public IList<Book> BookByNameAndYear(String pBookName, short pYear){
        IList<Book> lSource = this.BooksByYear(pYear);
        
        if (lSource.isEmpty()){ return null;}
       
        IList lResult = new List<Book>();
        
        IIterable<Book> lIterator = lSource.iterator();
         
        while(lIterator.hasNext()){
            
            Book lCurrent = lIterator.next();

            String lName = lCurrent.getName() == null ? "" : lCurrent.getName().toLowerCase();
            short lYear = lCurrent.getYear();
            
            if(lYear == pYear && lName.equals(pBookName.toLowerCase())){             
                System.out.println(lCurrent.toString());             
                lResult.add(new Node<>(lCurrent,lCurrent.getID()));
            }  
        }

        if (lResult.isEmpty()){ return null;}    
        return lResult;
    }
    
    public IList<Book> BookByAutorAndISBN(String pAutorName, String pISBN){
        
        IList<Book> lSource = this.BooksByAutor(pAutorName);
        if (lSource.isEmpty()){ return null;}
       
        IList lResult = new List<Book>();
        
        IIterable<Book> lIterator = lSource.iterator();
        while(lIterator.hasNext()){
            
            Book lCurrentBook = lIterator.next();
            
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
