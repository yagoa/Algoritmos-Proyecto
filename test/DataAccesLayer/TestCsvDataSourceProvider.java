/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Utils.Collections.Lists.IList;
import Utils.Const;
import Utils.MapperAutor;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yago
 */
public class TestCsvDataSourceProvider {
    
    public CSVDataSourceProvider lProvider;
    
    public TestCsvDataSourceProvider() {}  
  
    @Test
    public void testGetAllNormal()  {
        lProvider = new CSVDataSourceProvider(new MapperAutor(), Const.CSV.Separator ,Const.Files.Authors);
        
        IList result = null;
        try {
            result = lProvider.getAll();
        } 
        catch (Exception ex) {
            fail("Test testGetAllNormal");
        }
        
        assertNotNull(result);
        assertEquals(true, result.size()>0);
    }
    
    @Test(expected = NullPointerException.class)
    public void testGetAllBadPath() throws IOException  {
        IList result = null;
        lProvider = new CSVDataSourceProvider(new MapperAutor(), Const.CSV.Separator ,"");    
        result = lProvider.getAll();
        fail("Test testGetAllBadPath");
    }
    
    @Test
    public void testGetAllBadSeparator()throws IOException {
        IList result = null;
        lProvider = new CSVDataSourceProvider(new MapperAutor(), "," ,Const.Files.Authors);    
        result = lProvider.getAll(); 
        assertEquals(result.size(),0);
    }
    
    @Test(expected = NullPointerException.class)
    public void testGetAllNullMapper()throws IOException {
        IList result = null;
        lProvider = new CSVDataSourceProvider(null, Const.CSV.Separator ,Const.Files.Authors);    
        result = lProvider.getAll();
        fail("Test testGetAllNullMapper");
    }
    
    @Test(expected = NullPointerException.class)
    public void testGetAllNullParameters()throws IOException {
        IList result = null;
        lProvider = new CSVDataSourceProvider(null, null ,null);    
        result = lProvider.getAll();
        fail("Test testGetAllNullParameters");
    }
    
    @Test(expected = NullPointerException.class)
    public void testGetAllNullSeparator()throws IOException {
        IList result = null;
        lProvider = new CSVDataSourceProvider(new MapperAutor(), null, Const.Files.Authors);    
        result = lProvider.getAll();
        fail("Test testGetAllNullSeparator");
    }
    
    @Test(expected = NullPointerException.class)
    public void testGetAllNullFile()throws IOException {
        IList result = null;
        lProvider = new CSVDataSourceProvider(new MapperAutor(), Const.CSV.Separator, null);    
        result = lProvider.getAll();
        fail("Test testGetAllNullSeparator");
    }
    
}
