/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entitys.Autor;
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
public class TestMapperAutor {
    
    public Autor mAutor;
    public MapperAutor mMapper;
    IList<String> mPropertysString;


    public TestMapperAutor() {
    	mMapper = new MapperAutor();
    }

    @Before
    public void setUp() {
        mPropertysString = new List<String>();
    }


     /**
     * Test of SourceToEntity method, of class MapperCSVActorsTest in a normal case.
     */
    @Test
    public void testSourceToEntity() {
    	System.out.println("Test SourceToEntity");

    	mPropertysString.add(new Node<>("1", 1));   
	mPropertysString.add(new Node<>("Harper Lee", 2)); 

        mAutor = mMapper.SourceToEntity(mPropertysString);

        assertNotNull(mAutor);
        assertEquals(1, mAutor.getID());
        assertEquals("Harper Lee", mAutor.getName());
    }

     /**
     * Test of SourceToEntity method, of class MapperCSVActorsTest withe a null parameter case.
     */
    @Test(expected = NullPointerException.class)
    public void testSourceToEntityNullParameter() {
    	System.out.println("Test SourceToEntityNullParameter");

        mAutor = mMapper.SourceToEntity(null);
        fail("Fail Test SourceToEntityNullParameter");
    }

     /**
     * Test of SourceToEntity method, of class MapperCSVActorsTest withe a wrong  parameter order case.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSourceToEntityBadParameterFormat() {
    	System.out.println("Test SourceToEntityBadParameterFormat");
    	
	mPropertysString.add(new Node<>("Tom Cruise", 1)); 
    	mPropertysString.add(new Node<>("1", 0)); 

        mAutor = mMapper.SourceToEntity(mPropertysString);
        fail("Fail Test SourceToEntityBadParameterFormat");
    }
    
}
