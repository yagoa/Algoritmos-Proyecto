package Utils.Collections.Lists;

public interface INode<E> {

    /**
      * Returns the data contained in the node.
      *
      * @return Data contained in the node.
      */
    public E getData();

    /**
     * Assign a data node.
     * @param pData to assign. 
     */
    public void setData(E pData);

    /**
     * Assigns the next node to the current node.
     * @param pNode Node to assign as follows. 
     */
    public void setNext(INode<E> pNode);
    
    public void setPrev(INode<E> pNode);
    

    /**
      * Returns the next node to the current node.
      * @return Next node of the current
      */
    public INode<E> getNext();
    
    
    /**
     * Assigns the prev node to the current node.
     * @param pNode Node to assign as previews. 
     */
    public INode<E> getPrev();

    /**
     * Print data node
     */
    public String print();

    /**
     * Prints node label
     */
    public String printLabel();


    public boolean equals(INode<E> pNode);

    /**
     * Returns the node label
     * @return Node label
     */
    public Comparable getLabel();
    
    /**
     * Compare the current label withe other.
     * @param pLabel 
     * @return returns -1 if it has a lower label in Original, 0 if they are equal, 1 * if greater 
     */
    public int compareTo(Comparable pLabel);
}
