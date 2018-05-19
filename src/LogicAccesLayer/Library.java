/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicAccesLayer;

import DataAccesLayer.*;
import Entitys.*;
import Entitys.OneToMany;
import Utils.Collections.*;
import Utils.Collections.Lists.*;
import Utils.Collections.Lists.INode;
import Utils.SourceType;
import java.io.IOException;

/**
 *
 * @author yago
 */
public class Library {
    private final Repository BooksRepo;
    private final Repository TagsRepo;
    private final Repository AutorsRepo;
    private final Repository AutorBooksRepo;
    private final Repository BookTagsRepo;
    
    private StringBuilder messages;
    
    private Search Searcher;
    
    public Library()
    {
        this.TagsRepo = new TagRepository(SourceType.CSV);
        this.AutorsRepo = new AutorRepository(SourceType.CSV);
        this.BooksRepo = new BookRespository(SourceType.CSV);
        this.AutorBooksRepo = new AutorBookRepository(SourceType.CSV);
        this.BookTagsRepo = new BookTagRepository(SourceType.CSV);
        
        this.Searcher = new Search (this.BooksRepo,this.TagsRepo, this.AutorsRepo,this.AutorBooksRepo, this.BookTagsRepo);
    }
    
    public void Init() throws IOException
    {
        this.TagsRepo.loadAll();
        this.BooksRepo.loadAll();
        this.AutorBooksRepo.loadAll();
        this.BookTagsRepo.loadAll();
        this.AutorsRepo.loadAll();
        
        this.ReleateAutorsToBooks();
        this.ReleateTagsToBooks();
    }
    
    private void ReleateTagsToBooks()
    {
        IList books = this.BooksRepo.getAll();
        IList tags = this.TagsRepo.getAll();
        IList realations = this.BookTagsRepo.getAll();
        
        if((books != null && !books.isEmpty()) ||  
           (tags != null && !tags.isEmpty()) ||  
           (realations != null && !realations.isEmpty()))       
        {
             IIterable<OneToMany> iterator = realations.iterator();
             
             while(iterator.hasNext())
             {
                OneToMany bookTag = iterator.next();
                 
                INode<Book> bookNode = books.search(bookTag.getID());
                INode<Tag> tagNode = tags.search(bookTag.getOtherID());
                
                if(bookNode != null && tagNode!=null)
                {
                    Book book = bookNode.getData();
                    book.addTag(tagNode.getData());
                }
             }
        }
    } 
    
    private void ReleateAutorsToBooks()
    {
        IList books = this.BooksRepo.getAll();
        IList autors = this.AutorsRepo.getAll();
        IList realations = this.AutorBooksRepo.getAll();
        
        if((books != null && !books.isEmpty()) ||  
           (autors != null && !autors.isEmpty()) ||  
           (realations != null && !realations.isEmpty()))       
        {
             IIterable<OneToMany> iterator = realations.iterator();
             
             while(iterator.hasNext())
             {
                OneToMany bookAutor = iterator.next();
                 
                INode<Book>  bookNode = books.search(bookAutor.getID());
                INode<Autor> autorNode = autors.search(bookAutor.getOtherID());
                
                if(bookNode != null && autorNode!=null)
                {
                    Book book = bookNode.getData();
                    book.addAutor(autorNode.getData());
                }
             }
        }
    }
    
    public IList<Book> getBooks()
    {
        return this.BooksRepo.getAll();
    }
}
