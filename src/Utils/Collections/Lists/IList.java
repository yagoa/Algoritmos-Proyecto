package Utils.Collections.Lists;

import Utils.Collections.IIterable;


public interface IList<E> {

      /**
      * Method responsible for adding a node to the end of the list.
      *
      * @param PNode - Node to add
      */
    public void add(INode<E> pNode);

      /**
      * Method charge of finding a node whose key is indicated.
      *
      * @param Pkey - key node for.
      * @return Node found. If not found, return null.
      */
    public INode<E> search(Comparable pKey);

      /**
      * Method responsible for removing a node whose key is indicated.
      *
      * @param Key node Pkey deleted.
      * @return True if the removal has been completed successfully.
      */
    public boolean delete(Comparable pKey);

    
    /**
      * Method charge of printing on console keys nodes
      * Contained in the list.
      */
    public String print();

     /**
      * Returns a String with the keys separated by last separator
      * Parameter.
      *
      * @param PSeparator Separate keys
      * @return
      */
    public String print(String pSeparator);

      /**
      * Returns the number of items in the list. If the list
      * empty, return 0.
      *
      * @return Number of items in the list.
      */
    public int size();

     /**
      * Indicates whether or not the list contains elements.
      *
      * @return If you have any items.
      */
    public boolean isEmpty();

    
      /**
      * Returns the first node in the list.
      *
      * @return First node of the list.
      */
    public INode<E> getFirst();
    
    
    /** 
     * Returns an iterator for the list.
     * @return Iterable instance. 
     */
    public IIterable<E> iterator();
    
    
    @Override
    public  String toString();
    
}
