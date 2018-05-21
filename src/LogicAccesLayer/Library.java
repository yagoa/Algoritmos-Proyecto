/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicAccesLayer;

import DataAccesLayer.*;
import Entitys.*;
import Utils.Collections.Lists.*;
import Utils.Collections.Lists.INode;
import Utils.SourceType;
import java.io.IOException;

/**
 * Provide a set of methods and functions to perforrm all bussines operations
 * @author Yago Auza
 */
public class Library {
    private final Repository BooksRepo;
    private final Repository TagsRepo;
    private final Repository AutorsRepo;
    private final Repository AutorBooksRepo;
    private final Repository BookTagsRepo;
    
    private final Search Searcher;
      
    /**
     * Base class constructor.
     */
    public Library(){
        this.TagsRepo = new TagRepository(SourceType.CSV);
        this.AutorsRepo = new AutorRepository(SourceType.CSV);
        this.BooksRepo = new BookRespository(SourceType.CSV);
        this.AutorBooksRepo = new AutorBookRepository(SourceType.CSV);
        this.BookTagsRepo = new BookTagRepository(SourceType.CSV);
        
        this.Searcher = new Search (this.BooksRepo,this.TagsRepo, this.AutorsRepo,this.AutorBooksRepo, this.BookTagsRepo);
    }
    
    /**
     * Method that generates the instances and data that are prerequisites to perform operations
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operation
     * @see IOException
     */
    public void Init() throws IOException{
        this.TagsRepo.loadAll();
        this.BooksRepo.loadAll();
        this.AutorBooksRepo.loadAll();
        this.BookTagsRepo.loadAll();
        this.AutorsRepo.loadAll();
        
        this.ReleateAutorsToBooks();
        this.ReleateTagsToBooks();
    }
    
    /**
     * Return a Search instance
     * @see Search
     * @return Search instance
     */
    public Search GetSearcher(){
        return this.Searcher;
    }
    
    /**
     * Get a list of with all books and his releted entitys if exist from the source
     * @return List of books
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operation
     * @see IOException
     * @see IList
     * @see Book
     */
    public IList<Book> getBooks() throws IOException{
        return this.BooksRepo.getAll();
    }
    
    /**
     * Remove all books writen for an spesific autor, even if is not the only
     * autor thats write the book
     * @param pAutorName Autor name
     * @return True if books are removed from the source or false
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operation
     * @see IOException
     */
    public Boolean RemoveAutor(String pAutorName) throws IOException{
        if(pAutorName == null || pAutorName.equals(""))
            return false;
        
        IList<Book> lSource = BooksRepo.getAll();
        if (lSource.isEmpty())
            return false;
        
        IList<Book> lAutorBooks = this.Searcher.BooksByAutor(pAutorName);
        IList<Book> lBooksToDelete = new List<>();
        
        for(INode<Book> lNode = lAutorBooks.getFirst(); lNode != null; lNode = lNode.getNext()){
            Book lBook = lNode.getData();
            lBooksToDelete.add(lNode);
        }
        
        for(INode lNode = lBooksToDelete.getFirst(); lNode != null; lNode = lNode.getNext()){
            lSource.delete(lNode.getLabel());
        }     
        return true;
    }
    
    private void ReleateTagsToBooks() throws IOException{
        IList books = this.BooksRepo.getAll();
        IList tags = this.TagsRepo.getAll();
        IList realations = this.BookTagsRepo.getAll();
        
        if((books != null && !books.isEmpty()) ||  
           (tags != null && !tags.isEmpty()) ||  
           (realations != null && !realations.isEmpty())){         
               
             for(INode<BookTag> lNode = realations.getFirst(); lNode != null; lNode = lNode.getNext()){   
                BookTag bookTag = lNode.getData();
                 
                INode<Book> bookNode = books.search(bookTag.getID());
                INode<Tag> tagNode = tags.search(bookTag.getOtherID());
                
                if(bookNode != null && tagNode!=null){
                    Book book = bookNode.getData();
                    book.addTag(tagNode.getData());
                }
            }
        }
    } 
    
    private void ReleateAutorsToBooks() throws IOException{
        IList books = this.BooksRepo.getAll();
        IList autors = this.AutorsRepo.getAll();
        IList realations = this.AutorBooksRepo.getAll();
        
        if((books != null && !books.isEmpty()) ||  
           (autors != null && !autors.isEmpty()) ||  
           (realations != null && !realations.isEmpty())){
            
            for(INode<AutorBook> lNode = realations.getFirst(); lNode != null; lNode = lNode.getNext()){   
                
                AutorBook bookAutor = lNode.getData();
                 
                INode<Book>  bookNode = books.search(bookAutor.getID());
                INode<Autor> autorNode = autors.search(bookAutor.getOtherID());
                
                if(bookNode != null && autorNode!=null){
                    Book book = bookNode.getData();
                    book.addAutor(autorNode.getData());
                }
            }
        }
    }
}
