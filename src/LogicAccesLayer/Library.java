/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicAccesLayer;

import DataAccesLayer.*;
import Entitys.*;
import Utils.Collections.BinaryTree.BinaryTree;
import Utils.Collections.BinaryTree.IBinaryTree;
import Utils.Collections.BinaryTree.ITreeNode;
import Utils.Collections.BinaryTree.TreeNode;
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
    private final AutorBookRepository AutorBooksRepo;
    private final BookTagRepository BookTagsRepo;

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
            
        this.Searcher = new Search (this.BooksRepo,this.TagsRepo, this.AutorsRepo, this.BookTagsRepo);
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
        
        this.BookTagsRepo.LoadBinaryTree();
        this.AutorBooksRepo.LoadBinaryTree();
        
        this.ReleateAutorsToBooks();
        this.ReleateTagsToBooks();
        
        this.ReleteBooksWitoutTags();
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
        
        for(INode<Book> lNode = lBooksToDelete.getFirst(); lNode != null; lNode = lNode.getNext()){
            
            Book bookToDelete = lNode.getData();
            //Si se borra un libro, se debe obtener los tags
            this.RemoveBookFromBookTags(bookToDelete);
            lSource.delete(bookToDelete.getID());         
        }     
        return true;
    }
    
    /**
     * Remve a tag from the system
     * @param pTag String tag name
     * @return True if tag was removed from the source or false
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operation
     */
    public Boolean RemoveTag(String pTag) throws IOException{
        if(pTag == null || pTag.equals(""))
            return false;
        
        IList<Tag> lSource = TagsRepo.getAll();
        if (lSource.isEmpty())
            return false;
        
        Tag lTagToDelete = null;    
        for(INode<Tag> lNode = lSource.getFirst(); lNode != null; lNode = lNode.getNext()){
           if(lNode.getData().getTagName().equals(pTag)){
               lTagToDelete = lNode.getData();
               break;
           }
        }   
      
        if(lTagToDelete != null){
            IList<Book> lTagBooks = this.Searcher.BooksByTag(lTagToDelete.getTagName());
             
            for(INode<Book> lNode = lTagBooks.getFirst(); lNode != null; lNode = lNode.getNext()){   
                Book book = lNode.getData();
                
                book.getTags().delete(lTagToDelete.getID());
            } 
            
            BookTagsRepo.binaryTree.delete(lTagToDelete.getID());
        }
              
        return true;
    }
    
    private void RemoveBookFromBookTags(Book book){
        IList tags = book.getTags();
        
        if(tags != null && !tags.isEmpty()){
            
            for(INode<Tag> lNode = tags.getFirst(); lNode != null; lNode = lNode.getNext()){   
                
                Tag Tag = lNode.getData();
                ITreeNode<IList<Integer>> tagkNodeWithBooks = BookTagsRepo.binaryTree.search(Tag.getID());
                
                if(tagkNodeWithBooks != null){
                    // Borro el libro del nodo
                    tagkNodeWithBooks.getData().delete(book.getID());
                    
                    // Si el nodo se queda sin libros, borro el nodo
                    if(tagkNodeWithBooks.getData().isEmpty()) {
                        BookTagsRepo.binaryTree.delete(tagkNodeWithBooks.getTag());
                    }
                }
            }         
        }
    }
    
    private void ReleateTagsToBooks() throws IOException{
        /*IList books = this.BooksRepo.getAll();
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
        }*/
            
        IList books = this.BooksRepo.getAll();
        IList tags = this.TagsRepo.getAll();
        
        if((books != null && !books.isEmpty()) ||  
           (tags != null && !tags.isEmpty()) ||  
            (BookTagsRepo.binaryTree != null && !BookTagsRepo.binaryTree.isEmpty())){
            
            for(INode<Tag> lNode = tags.getFirst(); lNode != null; lNode = lNode.getNext()){   
                
                Tag Tag = lNode.getData();
                ITreeNode<IList<Integer>> tagkNodeWithBooks = BookTagsRepo.binaryTree.search(Tag.getID());
                        
                
                if(tagkNodeWithBooks != null){
                
                   IList<Integer> booksIds = tagkNodeWithBooks.getData();
                   
                   if(booksIds != null && !booksIds.isEmpty()){
                       
                        for(INode<Integer> lBookIdsNode = booksIds.getFirst(); lBookIdsNode != null; lBookIdsNode = lBookIdsNode.getNext()){  
                            Integer bookId = lBookIdsNode.getData();
                            
                            INode<Book> bookNode = books.search(bookId);
                            
                            if(bookNode!=null){
                                bookNode.getData().addTag(Tag);
                            }
                        }
                    }
                }
            }
        }
    } 
      
    private void ReleteBooksWitoutTags() throws IOException{
        
        IList books = this.BooksRepo.getAll();  
        IList<Integer> booksWitoutTagsIdsList = new List<>();
        
        for(INode<Book> lNode = books.getFirst(); lNode != null; lNode = lNode.getNext()){           
            Book book = lNode.getData();
            
            if(book.getTags() == null || book.getTags().isEmpty()){
                booksWitoutTagsIdsList.add(new Node(book.getID(), book.getID()));
            }
        }
        
        
        if(!booksWitoutTagsIdsList.isEmpty()){
            BookTagsRepo.binaryTree.add(new TreeNode(booksWitoutTagsIdsList, -1));
        }
    }
 
    private void ReleateAutorsToBooks() throws IOException{
        /*IList books = this.BooksRepo.getAll();
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
        }*/
        IList autors = this.AutorsRepo.getAll();
        IList books = this.BooksRepo.getAll();
        
        if((books != null && !books.isEmpty()) ||  
           (autors != null && !autors.isEmpty()) ||  
            (AutorBooksRepo.binaryTree != null && !AutorBooksRepo.binaryTree.isEmpty())){
            
            for(INode<Book> lNode = books.getFirst(); lNode != null; lNode = lNode.getNext()){   
                
                Book book = lNode.getData();
                ITreeNode<IList<Integer>> bookNodeWithAutors = AutorBooksRepo.binaryTree.search(book.getID());
                
                if(bookNodeWithAutors != null){
                
                   IList<Integer> autorsIds = bookNodeWithAutors.getData();
                   
                   if(autorsIds != null && !autorsIds.isEmpty()){
                       
                        for(INode<Integer> lAutorIdNode = autorsIds.getFirst(); lAutorIdNode != null; lAutorIdNode = lAutorIdNode.getNext()){  
                            Integer autorId = lAutorIdNode.getData();
                            
                            INode<Autor> autorNode = autors.search(autorId);
                            
                            if(autorNode!=null){
                                book.addAutor(autorNode.getData());
                            }
                        }
                    }
                }
            }
        }  
    }
    
}
