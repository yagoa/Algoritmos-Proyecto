package Utils.Collections.BinaryTree;


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
    public String preOrden();

    /**
     * Imprime en InOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden();

    /**
     * Imprime en PostOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String postOrden();

   
       /**
     * Elimina un elemento dada una etiqueta.
     * @param tag
     * @return 
     */
    public void delete(Comparable tag);
   
    
    public boolean clear();
	
}

