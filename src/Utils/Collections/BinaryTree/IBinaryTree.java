package Utils.Collections.BinaryTree;

import Utils.Collections.Lists.IList;
import java.util.LinkedList;


public interface IBinaryTree<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
 clave indicada en "node", retorna falso.
     *
     * @param node Elemento a insertar
     * @return Exito de la operaci�n
     */

    public boolean add(ITreeNode<T> node);

    /**
     * Busca un elemento dentro del �rbol.
     *
     *
     * @param tag Etiqueta identificadora del elemento a buscar.
     * .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public ITreeNode<T> search(Comparable tag);

    /**
     * Imprime en PreOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public IList<T> preOrden();

    /**
     * Imprime en InOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public IList<T> inOrden();

    /**
     * Imprime en PostOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public IList<T> postOrden();

   
       /**
     * Elimina un elemento dada una etiqueta.
     * @param tag
     * @return 
     */
    public void delete(Comparable tag);
   
    
    public boolean clear();
    
     public boolean isEmpty();
	
}

