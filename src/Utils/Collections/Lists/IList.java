package Utils.Collections.Lists;

public interface IList<E> {

    /**
     * Method responsible for adding a node to the end of the list.
     * @param pNode Node to add
     */
    public void add(INode<E> pNode);

    /**
     * Method charge of finding a node whose key is indicated.
     * @param pKey key node for.
     * @return Node found. If not found, return null.
     */
    public INode<E> search(Comparable pKey);

    /**
     * Method responsible for removing a node whose key is indicated.
     * @param pKey node pkey deleted.
     * @return True if the removal has been completed successfully.
     */
    public boolean delete(Comparable pKey);

    /**
     * Method charge of printing on console keys nodes , Contained in the list.
     * @return String representation for the list
     */
    public String print();

    /**
     * Returns a String with the keys separated by last separator
     * @param pSeparator Separate keys
     * @return String representation for the list
     */
    public String print(String pSeparator);

    /**
     * Returns the number of items in the list. If the list
     * empty, return 0.
     * @return Number of items in the list.
     */
    public int size();

    /**
     * Indicates whether or not the list contains elements.
     * @return If you have any items.
     */
    public boolean isEmpty();

    /**
     * Returns the first node in the list.
     * @return first node of the list.
     */
    public INode<E> getFirst();
    
    /**
     * Return the last node in the list
     * @return last node of the list.
     */
    public INode<E> getLast();
    
    /**
     * Itereate the list from the front of a node
     * @param pNode start node
     * @return next node
     */
    public INode<E> iterateForward(INode<E> pNode);
    
    /**
     * Itereate the list from the end of a node
     * @param pNode start node
     * @return prev node
     */
    public INode<E> iterateBackward(INode<E> pNode);

    @Override
    public  String toString();
    
}
