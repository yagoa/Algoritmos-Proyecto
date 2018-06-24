package Utils.Collections.BinaryTree;

import Utils.Collections.Lists.IList;

/**
 * Tree node interface to use ina binary tree
 * @author yago
 */
public interface ITreeNode<T> {

    /**
     * Get the value of the node tag.
     * @return Node Tag.
     */
    public Comparable getTag();

    /**
     * Get the left child of the node.
     * @return Left Son node.
     */
    public ITreeNode getLeftSon();

    /**
     * Get the right child of the node.
     * @return Right Son of the node.
     */
    public ITreeNode getRigthSon();

    /**
     * Assigns the left son of the node.
     * @param node Element to be assigned as a left son.
     */
    public void setLeftSon(ITreeNode node);

    /**
     * Assigns the right son of the node.
     * @param node Element to be assigned as the right child.
     */
    public void setRigthSon(ITreeNode node);

    /**
     * Find an item in the tree with the indicated tag.
     * @param tag from the node to search
     * @return Element found. If you can not find it, it returns null.
     */
    public ITreeNode search(Comparable tag);

    /**
     * Insert a node inside the tree.
     * @param node Element to add.
     * @return Success of the operation.
     */
    public boolean add(ITreeNode node);

    /**
     * Get a list of elements in the tree in preorden
     * @param unaLista a list of elements
     */
    public void preOrden(IList<T> unaLista);

    /**
     * Get a list of elements in the tree in inorden
     * @param unaLista a list of elements
     */
    public void inOrden(IList<T> unaLista);

    /**
     * Get a list of elements in the tree in postorden
     * @param unaLista a list of elements
     */
    public void postOrden(IList<T> unaLista);

    /**
     * Returns the data contained in the element.
     * @return Data
     */
    public T getData();
    
    /**
     * Remove an item given a tag.
     * @param tag from the node to delete
     * @return deleted node
     */
    public ITreeNode delete(Comparable tag);
	
}
