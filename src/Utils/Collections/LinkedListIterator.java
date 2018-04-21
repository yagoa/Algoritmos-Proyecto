/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Collections;

import Utils.Collections.Lists.INode;

/**
 * Provide a set of methods and functions to loop over lists 
 * related white actors
 * implements the interface IIterable.
 * @see IIterable
 * @author Yago Auza
 */
public class LinkedListIterator<E> implements IIterable {
     private INode<E> mCurrent; 

     /**
      * Base class contructor.
      * @param pCurrent Star node.
      */
     public LinkedListIterator(INode<E> pCurrent) { 
     	this.mCurrent = pCurrent; 
     }

     /**
      * Check if current node has a next node.
      * @return True or false
      */
    @Override
    public boolean hasNext() {
        if(mCurrent!= null)
            return mCurrent.getNext() != null;
        else
            return false;
    }

    /**
     * Get the current node data and set the cursor for the next if exist.
     * @return current node data.
     */
    @Override
    public E next() {       
        if(!this.hasNext()) { 
            return null; 
        }
        INode<E> lTemp =  this.mCurrent;
        mCurrent = mCurrent.getNext();
        return lTemp.getData();
    }
}
