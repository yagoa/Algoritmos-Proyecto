/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.BookTag;
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
public class TestBookTagRepository {
    
    BookTagRepository mRepository;
        
    @Before
    public void setUp() {
        mRepository = new BookTagRepository(SourceType.CSV);
    }
    
    @After
    public void tearDown() {
        mRepository = null;
    }

    @Test
    public void testLoadAll() throws IOException {        
        mRepository.loadAll();
        IList<BookTag> tags = mRepository.getAll();
        assertNotNull(tags);
        assertEquals(true, tags.size() > 0);
    }

    @Test(expected = NullPointerException.class)
    public void testLoadAll_NullPointerException() throws NullPointerException, IOException {
        mRepository = new BookTagRepository(null);         
        mRepository.loadAll();
        IList<BookTag> tags = mRepository.getAll();
        fail("Fail Test loadAllNullSurceType");
    } 
    
    @Test()
    public void testGetById() throws NullPointerException, IOException {
        mRepository.loadAll();
        BookTag first = mRepository.getAll().getFirst().getData();
        BookTag search = mRepository.GetById(first.getID());
        assertSame(search, first);
    } 
    
    @Test()
    public void testRemove() throws IOException {
        mRepository.loadAll();
        BookTag toRemove = mRepository.getAll().getFirst().getData();
        Boolean result = mRepository.Remove(toRemove);
        BookTag stillExist = mRepository.GetById(toRemove.getID());
        
        // la diefencia es que el id principal puede estar repetido ya que el archivo no tiene id propio
        assertNotNull(toRemove);
        assertTrue(result);
        assertNotSame(stillExist, toRemove);
    } 

   @Test(expected = NullPointerException.class)
    public void testCSVDataSourceNullRepositoryInstance() {
        BookTagRepository instance = null;
        instance.CSVDataSource();
    }  
}
