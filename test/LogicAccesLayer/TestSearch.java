/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicAccesLayer;

import Entitys.Autor;
import Entitys.Book;
import Entitys.Tag;
import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.INode;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yago
 */
public class TestSearch {
    
    public static Search instance;
    
    public TestSearch(){}
    
    @BeforeClass
    public static void setUp() throws IOException{
        Library libary = new Library();
        libary.Init();
        
        instance = libary.GetSearcher();
    }
      
    @Test
    public void testBooksByYear() {
        short lYear = 2014;
        IList<Book> result = instance.BooksByYear(lYear);
        
        for(INode<Book> lNode = result.getFirst(); lNode != null; lNode = lNode.getNext()){               
            Book lCurrent = lNode.getData();
           
            assertNotNull(lCurrent);
            assertTrue(lCurrent.getYear() >= (short)lYear);
        }
    }
    
    @Test
    public void testBooksByNotExitentYear() {
        short lYear = 30000;
        IList<Book> result = instance.BooksByYear(lYear);
        
        assertNotNull(result);
        assertTrue(result.size() == 0);
    }

    @Test
    public void testBooksByAutor() {
        Autor lAutor = new Autor(4);
        lAutor.setName("Harper Lee");
        
        IList<Book> result = instance.BooksByAutor(lAutor.getName());
        
        assertNotNull(result);
        assertTrue(result.size() > 0);
        
        for(INode<Book> lNode = result.getFirst(); lNode != null; lNode = lNode.getNext()){               
            
            Autor autorToFind = lNode.getData().getAutors().search(lAutor.getID()).getData();
            assertNotNull(autorToFind);
        }
    }
    
    @Test
    public void testBooksByAutorNotFound() {
        Autor lAutor = new Autor(-1);
        lAutor.setName("YagoAuza");
        
        IList<Book> result = instance.BooksByAutor(lAutor.getName());
        
        assertNotNull(result);
        assertTrue(result.size() == 0);
    }
    
    @Test
    public void testBooksByAutorBadParameters() {
    
        IList<Book> result = instance.BooksByAutor(null);     
        assertNotNull(result);
        assertTrue(result.size() == 0);
        
        result = instance.BooksByAutor("");    
        assertNotNull(result);
        assertTrue(result.size() == 0);
    }

    @Test
    public void testBooksByTag() {
        Tag lTag = new Tag(25);
        lTag.setTagName("-fiction");
        IList<Book> result = instance.BooksByTag(lTag.getTagName());
        
        assertNotNull(result);
        assertTrue(result.size() > 0);
        
        for(INode<Book> lNode = result.getFirst(); lNode != null; lNode = lNode.getNext()){               
            
            Tag TagToFind = lNode.getData().getTags().search(lTag.getID()).getData();
            assertNotNull(TagToFind);
        }
    }
    
    @Test
    public void testBooksByTagNotFound() {
        Tag lTag = new Tag(-1);
        lTag.setTagName("-mytag");
        
        IList<Book> result = instance.BooksByTag(lTag.getTagName());
        
        assertNotNull(result);
        assertTrue(result.size() == 0);
    }
    
    @Test
    public void testBooksByTagBadParameters() {
    
        IList<Book> result = instance.BooksByTag(null);     
        assertNotNull(result);
        assertTrue(result.size() == 0);
        
        result = instance.BooksByTag("");    
        assertNotNull(result);
        assertTrue(result.size() == 0);
    }

    @Test
    public void testBookByNameAndYear() {
        String pBookName = "The Hobbit";
        short pYear = 1937;
        IList<Book> result = instance.BookByNameAndYear(pBookName, pYear);
        
        assertNotNull(result);
        assertTrue(result.size() == 1);
    }
    
    @Test
    public void testBookByNameAndYearNotFound() {
        String pBookName = "The";
        short pYear = 5000;
        IList<Book> result = instance.BookByNameAndYear(pBookName, pYear);
        
        assertNotNull(result);
        assertTrue(result.size() == 0);
    }
    
    @Test
    public void testBookByNameAndYearBadParameter() {
        String pBookName = "";
        short pYear = 0;
        IList<Book> result = instance.BookByNameAndYear(pBookName, pYear);
        
        assertNotNull(result);
        assertTrue(result.size() == 0);
    }

    @Test
    public void testBookByAutorAndISBN() {
        String lAutorName = "Harper Lee";
        String lISBN1 = "618260307";
        String lISBN2 = "9780618260300";
        
        IList<Book> result = instance.BookByAutorAndISBN(lAutorName, lISBN1);
        assertNotNull(result);
        assertTrue(result.size() > 0);
        
        
        IList<Book> result2 = instance.BookByAutorAndISBN(lAutorName, lISBN2);
        assertNotNull(result2);
        assertTrue(result2.size() > 0);     
    }
    
    @Test
    public void testBookByAutorAndISBNBadISBN() {
        String lAutorName = "Harper Lee";
        String lISBN1 = "4444444";
        
        IList<Book> result = instance.BookByAutorAndISBN(lAutorName, lISBN1);
        assertNotNull(result);
        assertTrue(result.size() == 0);
    }
    
}
