package Utils.Collections.BinaryTree;

import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.List;

/**
* Search binary tree class representation , implements IBinaryTree.
* @see IBinaryTree
* @author  Yago Auza
*/
public class BinaryTree<T> implements IBinaryTree<T> {

    private ITreeNode<T> root;
    private int altura;

    /**
     * Full class contructor
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * add an element in the tree. In case there is already an element with the key indicated in "node", returns false.
     * @param node Element to insert
     * @return Success of the operation
     */
    @Override
    public boolean add(ITreeNode<T> node) {
        if (isEmpty()) 
        {
            root = node;
            return true;
        } 
        else 
        {
            return root.add(node);
        }
    }

    /**
     * Look for an element within the tree.
     * @param tag Identification tag of the item to search.
     * @return Element found. If you can not find it, it returns null.
     */
    @SuppressWarnings("unchecked")
    @Override
    public ITreeNode<T> search(Comparable tag) {
        if (isEmpty()) 
        {
            return null;
        } 
        else 
        {
            return root.search(tag);
        }
    }

    /**
     * Get a list of elements in the tree in inorden
     * @see IList
     * @return List of elements in inOrden
     */
    @Override
    public IList<T> inOrden() 
    {
        IList<T> listaInorden = null;
        if (!isEmpty()) {
            listaInorden = new List<>();
            root.inOrden(listaInorden);
        }
        return listaInorden;
    }

    /**
     * Get a list of elements in the tree in preorden
     * @see IList
     * @return List of elements in preorden
     */
    @Override
    public IList<T> preOrden() 
    {
        IList<T> listaPreOrden = null;
        if (!isEmpty()) {
            listaPreOrden = new List<>();
            root.preOrden(listaPreOrden);
        }
        return listaPreOrden;
    }

    /**
     * Get a list of elements in the tree in postorden
     * @see IList
     * @return List of elements in postorden
     */
    @Override
    public IList<T> postOrden()
    {
        IList<T> listaPostOrden = null;
        if (!isEmpty()) {
            listaPostOrden = new List<T>();
            root.postOrden(listaPostOrden);
        }
        return listaPostOrden;
    }
    
    /**
     * Delete an item given a tag.
     * @param tag tag key
     */
    @Override
    public void delete(Comparable tag) {
        if (!isEmpty()) 
        {
            this.root = this.root.delete(tag);
        }
    }


    /**
     * Clear binary tree
     * @return True if succes or false if not
     */
    @Override
    public boolean clear() {
        if (!isEmpty()) 
        {
            root = null;
            return true;
        }
        return false;
    }
    
    /**
     * Indicates whether or not the binary tree contains elements.
     * @return If you have any items return false.
     */
    @Override
    public boolean isEmpty()
    {
        return (root == null);
    }
}
