/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entitys.Book;
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
public class TestMapperBook {
    
    public Book mBook;
    public MapperBook mMapper;
    IList<String> mPropertysString;


    public TestMapperBook() {
    	mMapper = new MapperBook();
    }

    @Before
    public void setUp() {
        mPropertysString = new List<>();
    }

    @Test
    public void testSourceToEntity() {
    	mPropertysString.add(new Node<>("1", 1));   
	mPropertysString.add(new Node<>("Harry Poter", 2)); 

        mPropertysString.add(new Node<>("2007", 3)); 
        mPropertysString.add(new Node<>("3.2", 4));
        mPropertysString.add(new Node<>("2", 5)); 
        mPropertysString.add(new Node<>("1222-443-555", 6)); 


        mBook = mMapper.SourceToEntity(mPropertysString);

        assertNotNull(mBook);

        assertEquals(1, mBook.getID());
        assertEquals("Harry Poter", mBook.getName());
        assertEquals(2007, mBook.getYear());
        assertEquals(3,2f, mBook.getPoints());
        assertEquals(2, mBook.getCantPoints());
        assertEquals("1222-443-555", mBook.getISBN());
    }

    @Test(expected = NullPointerException.class)
    public void testSourceToEntityNullParameter() {
        mBook = mMapper.SourceToEntity(null);
        assertNull(mBook);
    }

    @Test
    public void testSourceToEntityBadParameterFormat() {
    	
        mPropertysString.add(new Node<>("Una mago niño", 3)); 
        mPropertysString.add(new Node<>("2007", 6)); 
        mPropertysString.add(new Node<>("id", 1));   
        mPropertysString.add(new Node<>("Harry Poter", 2)); 
        mPropertysString.add(new Node<>("Ciencia Ficcion", 5)); 
        mPropertysString.add(new Node<>("3.2", 4));

        mBook = mMapper.SourceToEntity(mPropertysString);
        
        assertNull(mBook);
    }
}
