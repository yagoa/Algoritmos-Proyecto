/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Collections.Lists;

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
public class TestList {
    
    List<String> instance;
    
    public TestList() {
    }
    
  
    @Before
    public void setUp() {
        instance = new List<String>();     
    }
    
    @After
    public void cleanUp() {
        instance = null;     
    }
    
    private void LoadTestData(){
        instance.add(new Node("first",1));
        instance.add(new Node("middle",2));
        instance.add(new Node("tail",3));
    }
    
    @Test
    public void testAdd() {
        
        INode first = new Node("first",1);
        INode lTail = new Node("tail",2);
        
        instance.add(first);
        instance.add(lTail);

        INode<String> lFirstResult = instance.search(1);
        INode<String> lTailResult = instance.search(2);
        
        assertEquals(first, lFirstResult);
        assertEquals(lTail, lTailResult);
        
        assertEquals(first.getNext(), lTailResult);
        assertEquals(first.getPrev(), null);
        
        assertEquals(lTail.getPrev(), first);
        assertEquals(lTail.getNext(), null);
    }

    @Test
    public void testSearch() {
        this.LoadTestData();
        
        INode result = instance.search(2);
        assertEquals(result.getData(), "middle");
        
        result = instance.search(1);
        assertEquals(result.getData(), "first");
        
        result = instance.search(3);
        assertEquals(result.getData(), "tail");
        
        result = instance.search(10);
        assertEquals(result, null);
    }

    @Test
    public void testDeleteFromBorders() {
        this.LoadTestData();
        
        boolean result = instance.delete(1);
        INode<String> searchResult = instance.search(1);
        
        assertEquals(searchResult, null);
        assertEquals(result, true);    
        assertNotEquals(instance.getFirst().getData(),"first");
        
        
        
        result = instance.delete(3);
        searchResult = instance.search(3);
        
        assertEquals(searchResult, null);
        assertEquals(result, true);    
        assertNotEquals(instance.getLast().getData(),"tail");
    }
    
    @Test
    public void testDeleteNotExitantNode() {
        this.LoadTestData();
        
        boolean result = instance.delete(8);
        INode<String> searchResult = instance.search(8);
        
        assertEquals(searchResult, null);
        assertEquals(result, false); 
    }
    
    @Test
    public void testDelete() {
        this.LoadTestData();
        
        boolean result = instance.delete(2);
        INode<String> searchResult = instance.search(2);
        
        assertEquals(searchResult, null);
        assertEquals(result, true); 
        
        assertEquals(instance.getFirst().getData(),"first");
        assertEquals(instance.getLast().getData(),"tail");
        
        assertEquals(instance.getFirst().getNext().getData(),"tail");
        assertEquals(instance.getLast().getPrev().getData(),"first");
    }
    
    @Test
    public void testEmptyList() {
        
        boolean result = instance.delete(1);
        INode<String> searchResult = instance.search(1);
        
        assertEquals(searchResult, null);
        assertEquals(result, false); 
    }

    @Test
    public void testSize() {
        this.LoadTestData();
        
        int result = instance.size();
        assertEquals(result, 3); 
        
        instance.delete(1);
        result = instance.size();
        assertEquals(result, 2);
        
        instance.add(new Node("new",4));
        result = instance.size();
        assertEquals(result, 3); 
        
        instance = new List<String>();
        result = instance.size();
        assertEquals(result, 0);
    }

    @Test
    public void testIsEmpty() {
        
        boolean result = instance.isEmpty();
        assertEquals(result, true);
        
        this.LoadTestData();
        result = instance.isEmpty();
        assertEquals(result, false);
        
        instance.delete(1);
        instance.delete(2);
        instance.delete(3);
        
        result = instance.isEmpty();
        assertEquals(result, true);
    }

    @Test
    public void testGetFirst() {
        this.LoadTestData();
        INode result = instance.getFirst();
        assertEquals(result.getData(), "first");
        
        instance.delete(1);
        
        result = instance.getFirst();
        assertEquals(result.getData(), "middle");
        
        instance.delete(2);
        
        result = instance.getFirst();
        assertEquals(result.getData(), "tail");
        
        instance = new List<String>();
        result = instance.getFirst();
        assertEquals(result, null);
    }

    @Test
    public void testGetLast() {
        this.LoadTestData();
        INode result = instance.getLast();
        assertEquals(result.getData(), "tail");
        
        instance.delete(3);
        
        result = instance.getLast();
        assertEquals(result.getData(), "middle");
        
        instance.delete(2);
        
        result = instance.getLast();
        assertEquals(result.getData(), "first");
        
        instance = new List<String>();
        result = instance.getLast();
        assertEquals(result, null);
    }

    @Test
    public void testIterateBackward() {
        this.LoadTestData();
        
        INode result = instance.iterateBackward(instance.getFirst());
        assertEquals(result, null);
        
        result = instance.iterateBackward(instance.getLast());
        assertEquals(result.getData(), "middle");     
    }
    
    @Test
    public void testIterateForward() {
        this.LoadTestData();
        
        INode result = instance.iterateForward(instance.getLast());
        assertEquals(result, null);
        
        result = instance.iterateForward(instance.getFirst());
        assertEquals(result.getData(), "middle");   
    }
   
}
