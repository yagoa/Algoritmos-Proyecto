/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicAccesLayer;

import Entitys.Book;
import Utils.Collections.Lists.IList;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yago
 */
public class TestLibrary {
    
    Library instance;
    
    public TestLibrary() {}
    
    @Before
    public void setUp() {
        instance = new Library();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInit() throws Exception {
        try{
            instance.Init();
            assertNotNull(instance.getBooks());
        }
        catch(Exception ex){
            fail("Exeption on init");
        }
    }

    @Test
    public void testGetSearcher() {
        Library instance = new Library();
        Search result = instance.GetSearcher();
        assertNotNull(result);
    }

    @Test
    public void testGetBooks() throws IOException {
        instance.Init();
        IList<Book> result = instance.getBooks();
        
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
    
    @Test
    public void testGetBooks_WithoutInit() throws IOException {
        IList<Book> result = instance.getBooks();      
        assertTrue(result.size() > 0);
    }

    @Test
    public void testRemoveAutor() throws IOException {
        String pAutorName = "Harper Lee";
        instance.Init();
        
        IList<Book> beforeDelete = instance.GetSearcher().BooksByAutor(pAutorName);  
        Boolean result = instance.RemoveAutor(pAutorName);      
        IList<Book> afterDelete = instance.GetSearcher().BooksByAutor(pAutorName);
        
        assertNotNull(afterDelete);
        assertTrue(afterDelete.size() == 0);
        assertTrue(beforeDelete.size() > 0);
        assertTrue(result);
    } 
}
