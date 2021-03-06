/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicAccesLayer;

import DataAccesLayer.BookTagRepository;
import DataAccesLayer.Repository;
import Entitys.*;
import Utils.Collections.BinaryTree.ITreeNode;
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
    private final BookTagRepository BookTagsRepo;
    
    /**
     * Base class constructor.
     * @param pBooksRepo book repository instance
     * @param pTagsRepo tags repository instance
     * @param pAutorsRepo autors repository instance
     * @param pBookTags bookTags repository instance
     */
    public Search(Repository pBooksRepo,Repository pTagsRepo,Repository pAutorsRepo, BookTagRepository pBookTags){
        this.TagsRepo = pTagsRepo;
        this.AutorsRepo = pAutorsRepo;
        this.BooksRepo = pBooksRepo;
        this.BookTagsRepo = pBookTags;
    }
    
    /**
     * Get a list of books from a certain year of publication.
     * @param pYear book year
     * @return List of books
     * @see Book
     * @see IOException
     * @see IList
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operation
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
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operation
     */
    public IList<Book> BooksByAutor(String pAutorName) throws IOException{
        IList<Book> lResult = new List<Book>();
        
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
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operation
     */
    public IList<Book> BooksByTag(String pTag) throws IOException{
        /*
        IList<Book> lResult = new List();   
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
                        lResult.add(new Node<>(lCurrentBook,lCurrentBook.getID()));
                    }
                }
            }     
        }*/
        
        
        IList<Book> lResult = new List();   
        if(pTag == null || pTag.equals(""))
            return lResult;
        
        IList<Book> lSource = BooksRepo.getAll();
        if (lSource.isEmpty())
             return lResult;
        
        IList<Tag> lTagSource = TagsRepo.getAll();
        
        for(INode<Tag> lNodeTag = lTagSource.getFirst(); lNodeTag != null; lNodeTag = lNodeTag.getNext()){ 

            Tag lCurrentTag = lNodeTag.getData();
            if(lCurrentTag.getTagName().toLowerCase().equals(pTag.toLowerCase())){
                
                ITreeNode<IList<Integer>> tagNodeWithBooks = BookTagsRepo.binaryTree_TagWitheBooks.search(lCurrentTag.getID());
                
                if(tagNodeWithBooks != null){
                    
                    IList<Integer> booksIds = tagNodeWithBooks.getData();
                   
                    for(INode<Integer> lBookIdsNode = booksIds.getFirst(); lBookIdsNode != null; lBookIdsNode = lBookIdsNode.getNext()){  
                        
                        Integer bookId = lBookIdsNode.getData();
                        INode<Book> bookNode = lSource.search(bookId);

                        if(bookNode!=null){
                           lResult.add(new Node<>(bookNode.getData(),bookNode.getData().getID()));
                        }
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
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operation
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
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operation
     */
    public IList<Book> BookByAutorAndISBN(String pAutorName, String pISBN) throws IOException{
        
        IList<Book> lResult = new List<Book>();
        IList<Book> lSource = this.BooksByAutor(pAutorName);
        if (lSource.isEmpty())
            return lResult;
             
        for(INode<Book> lNode = lSource.getFirst(); lNode != null; lNode = lNode.getNext()){
            
            Book lCurrentBook = lNode.getData();
            
            String lISBNBoth = lCurrentBook.getISBN() != null ? lCurrentBook.getISBN() : "/";
            String[] lISBN = lISBNBoth.split("/");
            
            if(lISBN.length != 0 && (lISBN[0].equals(pISBN) || lISBN[1].equals(pISBN))){
                lResult.add(new Node<Book>(lCurrentBook,lCurrentBook.getID()));      
            }
        }     
        return lResult;
    }   
    
    /**
     * Get a list of books with all tags pass as parameter
     * @param tags List of tags names to search
     * @return List of books releted withe the tags
     * @see Book
     * @see IOException
     * @see IList
     * @see Tag
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operation
     */
    public IList<Book> BooksByTags(IList<String> tags) throws IOException{
        
        IList<Book> booksResult = new List();
        
         for(INode<String> lNode = tags.getFirst(); lNode != null; lNode = lNode.getNext()){
             
             String tag = lNode.getData();
             
             IList<Book> books = this.BooksByTag(tag);
             
              for(INode<Book> lBookNode = books.getFirst(); lBookNode != null; lBookNode = lBookNode.getNext()){
                  booksResult.add(lBookNode);
              }       
         }      
         return booksResult;
    }
}
