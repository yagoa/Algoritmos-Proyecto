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
    
    public IList<Book> FindLastEditions(short pYear){
        IList<Book> lSource = BooksRepo.getAll();
  
        if (lSource.isEmpty()){ return null;}
       
        IList lResult = new List<Book>();
        
        IIterable<Book> lIterator = lSource.iterator();       
        while(lIterator.hasNext()){
            
            Book lCurrent = lIterator.next();
            if(lCurrent.getYear() >= pYear){
                
                System.out.println(lCurrent.toString());
                
                lResult.add(new Node<Book>(lCurrent,lCurrent.getID()));
            }  
        }
        
        if (lResult.isEmpty()){ return null;}
       
       return lResult;
    }
}
