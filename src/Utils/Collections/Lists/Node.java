package Utils.Collections.Lists;

/**
 * Class that represent a simple node list for collections.
 * Implements INode
 * @see INode
 * @author ucu
 * @param <T> Generic object type
 */
public class Node<T> implements INode<T> {

    private final Comparable mLabel;
    private T mData;
    private INode<T> mNext = null;
    private INode<T> mPrev = null;

    
    /**
     * Base class constructor.
     * @param pData Node data.
     * @param pLabel Node Label.
     */
    public Node(T pData, Comparable pLabel) {
        this.mData = pData;
        this.mLabel = pLabel;
    }
    
      /**
      * Returns the data contained in the node.
      *
      * @return Data contained in the node.
      */
    @Override
    public T getData() {
        return this.mData;
    }
    
    /**
     * Assign a data node.
     * @param pData to assign. 
     */
    @Override
    public void setData(T pData) {
        this.mData = pData;

    }
    /**
     * Returns the node label
     *
     * @return Node label
     */
    @Override
    public Comparable getLabel() {
        return this.mLabel;
    }

    /**
     * Assigns the next node to the current node.
     * @param pNode Node to assign as follows. 
     */
    @Override
    public void setNext(INode<T> pNode) {
        this.mNext = pNode;

    }
    
    /**
     * Assigns the prev node to the current node.
     * @param pNode Node to assign as previews. 
     */
    @Override
    public void setPrev(INode<T> pNode) {
        this.mPrev = pNode;

    }
    /**
      * Returns the next node to the current node.
      * @return Next node of the current
     
     * @return Next node from the current */
    @Override
    public INode<T> getNext() {
        return this.mNext;
    }
    
    @Override
    public INode<T> getPrev() {
       return this.mPrev;
    }
    
    /**
     * Print data node
    
     * @return  */
    @Override
    public String print() {
        return mData.toString();
    }

    /**
     * Prints node label
    
     * @return  */
    @Override
    public String printLabel() {
        return this.mLabel.toString();
    }


    @Override
    public boolean equals(INode<T> pNode) {
        return this.mData.equals(pNode.getData());
    }
    /**
     * Compare the current label withe other.
     * @param pLabel Key label to compare a node
     * @return returns -1 if it has a lower label in Original, 0 if they are equal, 1 * if greater 
     */
    @Override
    public int compareTo(Comparable pLabel) {
        return this.mLabel.compareTo(pLabel);
    }
}
