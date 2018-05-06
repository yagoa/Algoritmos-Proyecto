/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entitys.Tag;
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
public class TestMapperTag {
    
    public Tag mTag;
    public MapperTag mMapper;
    IList<String> mPropertysString;


    public TestMapperTag() {
    	mMapper = new MapperTag();
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
    	mPropertysString.add(new Node<>("1", 1));   
	mPropertysString.add(new Node<>("Accion", 2)); 

        mTag = mMapper.SourceToEntity(mPropertysString);

        assertNotNull(mTag);
        assertEquals(1, mTag.getID());
        assertEquals("Accion", mTag.getTagName());
    }

     /**
     * Test of SourceToEntity method, of class MapperCSVActorsTest withe a null parameter case.
     */
    @Test(expected = NullPointerException.class)
    public void testSourceToEntityNullParameter() {
        mTag = mMapper.SourceToEntity(null);
        assertNull(mTag);
    }

     /**
     * Test of SourceToEntity method, of class MapperCSVActorsTest withe a wrong  parameter order case.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSourceToEntityBadParameterFormat() {	
	mPropertysString.add(new Node<>("Tom Cruise", 1)); 
    	mPropertysString.add(new Node<>("1", 0)); 

        mTag = mMapper.SourceToEntity(mPropertysString);
    }
    
}
