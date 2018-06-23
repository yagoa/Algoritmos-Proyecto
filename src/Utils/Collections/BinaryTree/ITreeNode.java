package Utils.Collections.BinaryTree;

import Utils.Collections.Lists.IList;
import java.util.LinkedList;



public interface ITreeNode<T> {

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getTag();

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public ITreeNode getLeftSon();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public ITreeNode getRigthSon();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @param node
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setLeftSon(ITreeNode node);

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @param node
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setRigthSon(ITreeNode node);

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param tag del nodo a search
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public ITreeNode search(Comparable tag);

 

    /**
     * Inserta un node dentro del arbol.
     *
     * @param node Elemento a add.
     * @return Exito de la operaci�n.
     */
    public boolean add(ITreeNode node);

    /**
     * Imprime en preorden el arbol separado por guiones.
     *
     * @param unaLista
     * @return String conteniendo el PreOrden
     */
    public void preOrden(IList<T> unaLista);

    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public void inOrden(IList<T> unaLista);

    /**
     * Imprime en postorden el arbol separado por guiones.
     *
     * @param unaLista
     * @return String conteniendo el PostOrden
     */
    public void postOrden(IList<T> unaLista);

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
    public T getData();
    
    /**
     * Elimina un elemento dada una etiqueta.
     * @param tag
     * @return 
     */
    public ITreeNode delete(Comparable tag);
	
}
