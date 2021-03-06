/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.Book;
import Utils.Collections.Lists.*;
import Utils.SourceType;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yago
 */
public class TestBookRespository {
    
    BookRespository mRepository;
        
    @Before
    public void setUp() {
        mRepository = new BookRespository(SourceType.CSV);
    }
    
    @After
    public void tearDown() {
        mRepository = null;
    }

    @Test
    public void testLoadAll() throws IOException {        
        mRepository.loadAll();
        IList<Book> book = mRepository.getAll();
        assertNotNull(book);
        assertEquals(true, book.size() > 0);
    }

    @Test(expected = NullPointerException.class)
    public void testLoadAll_NullPointerException() throws NullPointerException, IOException {
        mRepository = new BookRespository(null);         
        mRepository.loadAll();
        IList<Book> book = mRepository.getAll();
        fail("Fail Test loadAllNullSurceType");
    } 
    
    @Test()
    public void testGetById() throws NullPointerException, IOException {
        mRepository.loadAll();
        Book first = mRepository.getAll().getFirst().getData();
        Book search = mRepository.GetById(first.getID());
        assertSame(search, first);
    } 
    
    @Test()
    public void testRemove() throws IOException {
        mRepository.loadAll();
        Book toRemove = mRepository.getAll().getFirst().getData();
        Boolean result = mRepository.Remove(toRemove);
        Book stillExist = mRepository.GetById(toRemove.getID());
        
        assertNotNull(toRemove);
        assertTrue(result);
        assertNull(stillExist);
    } 

   @Test(expected = NullPointerException.class)
    public void testCSVDataSourceNullRepositoryInstance() {
        BookTagRepository instance = null;
        instance.CSVDataSource();
    }
    
}
