/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Collections;

/**
* This interface is used for loop collections.
* @author  Yago Auza
* @version 1.0
*/
public interface IIterable <E> {
    
    /**
     * Check if the collection has a next value.
     * @return True or false.
     */
    public boolean hasNext();
    
    /**
     * Get the current node value and set the next node.
     * @return Node data.
     */
    public E next();
}
