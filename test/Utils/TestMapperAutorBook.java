/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entitys.AutorBook;
import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.List;
import Utils.Collections.Lists.Node;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author yago
 */
public class TestMapperAutorBook {
    
    public AutorBook mAutorBook;
    public MapperAutorBook mMapper;
    IList<String> mPropertysString;


    public TestMapperAutorBook() {
    	mMapper = new MapperAutorBook();
    }

    @Before
    public void setUp() {
        mPropertysString = new List<String>();
    }


    @Test
    public void testSourceToEntity() {
    	mPropertysString.add(new Node<>("1", 1));   
	mPropertysString.add(new Node<>("2", 2)); 

        mAutorBook = mMapper.SourceToEntity(mPropertysString);

        assertNotNull(mAutorBook);
        assertEquals(1, mAutorBook.getID());
        assertEquals(2, mAutorBook.getOtherID());
    }

    
    @Test(expected = NullPointerException.class)
    public void testSourceToEntityNullParameter() {
        mAutorBook = mMapper.SourceToEntity(null);
        assertNull(mAutorBook);
    }
}
