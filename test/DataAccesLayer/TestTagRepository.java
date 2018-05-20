/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.Tag;
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
public class TestTagRepository {
    
    TagRepository mRepository;
        
    @Before
    public void setUp() {
        mRepository = new TagRepository(SourceType.CSV);
    }
    
    @After
    public void tearDown() {
        mRepository = null;
    }

    @Test
    public void testLoadAll() throws IOException {        
        mRepository.loadAll();
        IList<Tag> tags = mRepository.getAll();
        assertNotNull(tags);
        assertEquals(true, tags.size() > 0);
    }

    @Test(expected = NullPointerException.class)
    public void testLoadAll_NullPointerException() throws NullPointerException, IOException {
        mRepository = new TagRepository(null);         
        mRepository.loadAll();
        IList<Tag> tags = mRepository.getAll();
        fail("Fail Test loadAllNullSurceType");
    } 
    
    @Test()
    public void testGetById() throws NullPointerException, IOException {
        mRepository.loadAll();
        Tag first = mRepository.getAll().getFirst().getData();
        Tag search = mRepository.GetById(first.getID());
        assertSame(search, first);
    } 
    
    @Test()
    public void testRemove() throws IOException {
        mRepository.loadAll();
        Tag toRemove = mRepository.getAll().getFirst().getData();
        Boolean result = mRepository.Remove(toRemove);
        Tag stillExist = mRepository.GetById(toRemove.getID());
        
        assertNotNull(toRemove);
        assertTrue(result);
        assertNull(stillExist);
    } 
   
   @Test(expected = NullPointerException.class)
    public void testCSVDataSourceNullRepositoryInstance() {
        TagRepository instance = null;
        instance.CSVDataSource();
        fail("The test case is a prototype.");
    }
    
}
