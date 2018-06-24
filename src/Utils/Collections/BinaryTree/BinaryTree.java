package Utils.Collections.BinaryTree;

import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.List;

/**
 * @author Programacion2
 * @param <T>
 *
 */
public class BinaryTree<T> implements IBinaryTree<T> {

    private ITreeNode<T> root;
    private int altura;


    public BinaryTree() {
        root = null;
    }

    /**
     * @param node
     * @return
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
     * @param tag
     * @return
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
     * @return recorrida en inorden del arbol, null en caso de ser vacío
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
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
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
     * @return recorrida en postOrden del arbol, null en caso de ser vacío
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

    @Override
    public void delete(Comparable tag) {
        if (!isEmpty()) 
        {
            this.root = this.root.delete(tag);
        }
    }

    /**
     * @return
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
    
    public boolean isEmpty()
    {
        return (root == null);
    }
}
