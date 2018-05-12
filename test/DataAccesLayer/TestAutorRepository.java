/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.Autor;
import Utils.Collections.Lists.IList;
import Utils.SourceType;
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
public class TestAutorRepository {
    
    AutorRepository mRepository;
       
    
    @Before
    public void setUp() {
        mRepository = new AutorRepository(SourceType.CSV);
    }
    
    @After
    public void tearDown() {
        mRepository = null;
    }

    @Test
    public void testLoadAll() throws IOException {        
        mRepository.loadAll();
        IList<Autor> autors = mRepository.getAll();
        assertNotNull(autors);
        assertEquals(true, autors.size() > 0);
    }

    @Test(expected = NullPointerException.class)
    public void testLoadAll_NullPointerException() throws NullPointerException, IOException {
        System.out.println("Test loadAllNullSurceType");
        mRepository = new AutorRepository(null);         
        mRepository.loadAll();
        IList<Autor> autors = mRepository.getAll();
        fail("Fail Test loadAllNullSurceType");
    } 
    
    @Test()
    public void testGetById() throws NullPointerException, IOException {
        mRepository.loadAll();
        Autor first = mRepository.getAll().getFirst().getData();
        Autor search = mRepository.GetById(first.getID());
        assertSame(search, first);
    } 
    
    @Test()
    public void testRemove() throws IOException {
        mRepository.loadAll();
        Autor toRemove = mRepository.getAll().getFirst().getData();
        Boolean result = mRepository.Remove(toRemove);
        Autor stillExist = mRepository.GetById(toRemove.getID());
        
        assertNotNull(toRemove);
        assertTrue(result);
        assertNull(stillExist);
    } 
}
