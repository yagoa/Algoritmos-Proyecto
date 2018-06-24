/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Collections.BinaryTree;

import Utils.Collections.Lists.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yago
 */
public class TestBinaryTree {
    
    IBinaryTree<Integer> instance;
    
    public TestBinaryTree() {
    }
    
    @Before
    public void setUp() {
        instance = new BinaryTree<Integer>();
    }
    
    @After
    public void cleanUp() {
        instance = null;   
    }
    
    
    @Test
    public void testAdd() {
        
        ITreeNode root = new TreeNode(2,2);
        ITreeNode left = new TreeNode(1,1);
        ITreeNode rigth = new TreeNode(3,3);
        
        assertTrue(instance.add(root));
        assertTrue(instance.add(left));
        assertTrue(instance.add(rigth));
        assertFalse(instance.isEmpty());
        
        ITreeNode rootSearch = instance.search(2);
        
        assertEquals(rootSearch.getLeftSon(), left);
        assertEquals(rootSearch.getRigthSon(), rigth);    
    }
    
    @Test
    public void testSearch() {
        
        instance.add( new TreeNode(2,2));
        instance.add(new TreeNode(1,1));
        instance.add(new TreeNode(3,3));
        
        ITreeNode search = instance.search(2);
        assertEquals(search.getData(), 2);  
        
        search = instance.search(1);
        assertEquals(search.getData(), 1); 
        
        search = instance.search(3);
        assertEquals(search.getData(), 3); 
    }
    
    @Test
    public void testDelete(){
        instance.add( new TreeNode(2,2));
        instance.add(new TreeNode(1,1));
        instance.add(new TreeNode(3,3));
        
        instance.delete(1);
        ITreeNode search = instance.search(1);
        assertNull(search);  
        
        instance.delete(2);
        search = instance.search(2);
        assertNull(search);  
        
        search = instance.search(3);
        assertEquals(search.getData(), 3); 
    }
    
    @Test
    public void testClear(){
        instance.add( new TreeNode(2,2));
        instance.add(new TreeNode(1,1));
        instance.add(new TreeNode(3,3));
        
        assertTrue(instance.clear());       
        assertTrue(instance.isEmpty());
              
        ITreeNode search = instance.search(2);
        assertNull(search);  
    }
}
