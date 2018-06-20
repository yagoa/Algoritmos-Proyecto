package Utils.Collections.BinaryTree;

/**
 * @author Programacion2
 * @param <T>
 *
 */
public class BinaryTree<T> implements IBinaryTree<T> {

    private ITreeNode<T> root;
    private int altura;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

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
    public String inOrden() 
    {
        if (isEmpty()) 
        {
            return null;
        } 
        else 
        {
            return root.inOrden();
        }
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    @Override
    public String preOrden() 
    {
        if (isEmpty()) 
        {
            return null;
        } 
        else 
        {
            return root.preOrden();
        }
    }

    /**
     * @return recorrida en postOrden del arbol, null en caso de ser vacío
     */
    @Override
    public String postOrden()
    {
        if (isEmpty()) 
        {
            return null;
        } 
        else 
        {
            return root.postOrden();
        }
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
    
    private boolean isEmpty()
    {
        return (root == null);
    }
}
