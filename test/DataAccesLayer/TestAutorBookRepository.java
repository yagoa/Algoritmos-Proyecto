/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.AutorBook;
import Utils.Collections.BinaryTree.IBinaryTree;
import Utils.Collections.Lists.IList;
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
public class TestAutorBookRepository {
    
    AutorBookRepository mRepository;
       
    
    @Before
    public void setUp() {
        mRepository = new AutorBookRepository(SourceType.CSV);
    }
    
    @After
    public void tearDown() {
        mRepository = null;
    }

    @Test
    public void testLoadAll() throws IOException {        
        mRepository.loadAll();
        IList<AutorBook> autorsBook = mRepository.getAll();
        assertNotNull(autorsBook);
        assertEquals(true, autorsBook.size() > 0);
    }

    @Test(expected = NullPointerException.class)
    public void testLoadAll_NullPointerException() throws NullPointerException, IOException {
        mRepository = new AutorBookRepository(null);         
        mRepository.loadAll();
        IList<AutorBook> autorsBooks = mRepository.getAll();
    } 
    
    @Test()
    public void testGetById() throws NullPointerException, IOException {
        mRepository.loadAll();
        AutorBook first = mRepository.getAll().getFirst().getData();
        AutorBook search = mRepository.GetById(first.getID());
        assertSame(search, first);
    } 
    
    @Test()
    public void testRemove() throws IOException {
        mRepository.loadAll();
        AutorBook toRemove = mRepository.getAll().getFirst().getData();
        Boolean result = mRepository.Remove(toRemove);
        AutorBook stillExist = mRepository.GetById(toRemove.getID());
        
        assertNotNull(toRemove);
        assertTrue(result);
        assertNotSame(toRemove,stillExist);
    }    
    
    @Test(expected = NullPointerException.class)
    public void testCSVDataSourceNullRepositoryInstance() {
        BookTagRepository instance = null;
        instance.CSVDataSource();
    }  
    
    
        
    @Test()
    public void testLoadBinaryTree() throws IOException {
        mRepository.LoadBinaryTree();
        
        assertNotNull(mRepository.binaryTree);
        
    }  
}
