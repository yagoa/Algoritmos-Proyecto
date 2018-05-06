/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entitys.BookTag;
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
public class TesMappertBookTag {
     
    public BookTag mBookTag;
    public MapperBookTag mMapper;
    IList<String> mPropertysString;


    public TesMappertBookTag() {
    	mMapper = new MapperBookTag();
    }

    @Before
    public void setUp() {
        mPropertysString = new List<String>();
    }


     /**
     * Test of SourceToEntity method, of class MapperCSVMoviesDirectors in a normal case.
     */
    @Test
    public void testSourceToEntity() {
    	mPropertysString.add(new Node<>("1", 1));   
	mPropertysString.add(new Node<>("2", 2)); 

        mBookTag = mMapper.SourceToEntity(mPropertysString);

        assertNotNull(mBookTag);
        assertEquals(1, mBookTag.getID());
        assertEquals(2, mBookTag.getOtherID());
    }

     /**
     * Test of SourceToEntity method, of class MapperCSVMoviesDirectors withe a null parameter case.
     */
    @Test(expected = NullPointerException.class)
    public void testSourceToEntityNullParameter() {
        mBookTag = mMapper.SourceToEntity(null);
        assertNull(mBookTag);
    }
}
