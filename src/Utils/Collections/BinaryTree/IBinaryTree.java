package Utils.Collections.BinaryTree;

import Utils.Collections.Lists.IList;

/**
 * Search binary tree interface representation
 * @author yago
 */
public interface IBinaryTree<T> {

    /**
     * add an element in the tree. In case there is already an element with the key indicated in "node", returns false.
     * @param node Element to insert
     * @return Success of the operation
     */
    public boolean add(ITreeNode<T> node);

    /**
     * Look for an element within the tree.
     * @param tag Identification tag of the item to search.
     * @return Element found. If you can not find it, it returns null.
     */
    public ITreeNode<T> search(Comparable tag);

    /**
     * Get a list of elements in the tree in preorden
     * @see IList
     * @return List of elements in preorden
     */
    public IList<T> preOrden();

    /**
     * Get a list of elements in the tree in inorden
     * @see IList
     * @return List of elements in inOrden
     */
    public IList<T> inOrden();

    /**
     * Get a list of elements in the tree in postorden
     * @see IList
     * @return List of elements in postorden
     */
    public IList<T> postOrden();

    /**
     * Delete an item given a tag.
     * @param tag tag key
     */
    public void delete(Comparable tag);
   
    /**
     * Clear binary tree
     * @return True if succes or false if not
     */
    public boolean clear();
    
    /**
     * Indicates whether or not the binary tree contains elements.
     * @return If you have any items return false.
     */
    public boolean isEmpty();
	
}

