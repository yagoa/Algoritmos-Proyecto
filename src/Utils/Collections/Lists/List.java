package Utils.Collections.Lists;



/**
* Simple linked list class representation , implements IList.
* @see IList
* @author  Yago Auza
*/
public class List<E> implements IList<E> {

    private INode<E> mFirst;
    private INode<E> mTail;
    private int mSise;

    /**
     */
    public List() {
        this.mFirst = null;
        this.mTail = null;
        this.mSise = 0;
    }

    /**
     * Full class contructor
     * @param pNode First list node.
     */
    public List(INode<E> pNode) {
        this.mFirst = pNode;
        this.mTail = pNode;
        this.mSise = 0;
    }
    
      /**
      * Method responsible for adding a node to the end of the list.
      *
      * @param PNode - Node to add
      */
    @Override
    public void add(INode<E> pNewNode) {
        if (this.isEmpty()) {
            this.mFirst = pNewNode;
            this.mTail = pNewNode;
        }
        else {
            pNewNode.setPrev(this.mTail);
            this.mTail.setNext(pNewNode);
            this.mTail = pNewNode;
        }    
        this.mSise++;
    }
      /**
      * Method charge of finding a node whose key is indicated.
      *
      * @param Pkey - key node for.
      * @return Node found. If not found, return null.
      */
    @Override
    public INode<E> search(Comparable key) 
    {
        if (isEmpty()){ return null;}
        
        if (isEmpty()){ return null;}
        
        INode<E> lFromTail = this.mTail;
        INode<E> lFromFirst = this.mFirst;
     
        if(lFromTail.getLabel().equals(key)){
            return lFromTail;
        }
        if(lFromFirst.getLabel().equals(key)){
            return lFromFirst;
        }
        
        Boolean searcheEnd = false;
       
        while(!searcheEnd){
            lFromTail = this.iterateBackward(lFromTail);
            lFromFirst = this.iterateForward(lFromFirst);
            
            if(lFromTail != null && lFromTail.getLabel().equals(key)){
                return lFromTail;
            }
            if(lFromFirst != null && lFromFirst.getLabel().equals(key)){
                return lFromFirst;
            }
            
            if((lFromTail == null && lFromFirst == null) || (lFromTail.getLabel().equals(lFromFirst.getLabel()))){
                searcheEnd = true;
            }
        }     
        return null;   
    }
      /**
      * Method responsible for removing a node whose key is indicated.
      *
      * @param Key node Pkey deleted.
      * @return True if the removal has been completed successfully.
      */
    @Override
    public boolean delete(Comparable pKey) {
        if (isEmpty())  return false;
        
        INode<E> lToRemove = this.search(pKey);   
        
        if(lToRemove == null) {return false;}
        
        if(this.mSise > 0){
            INode<E> lToRemovePrev = lToRemove.getPrev();
            INode<E> lToRemoveNext = lToRemove.getNext();

            if(lToRemovePrev != null)
                lToRemovePrev.setNext(lToRemove.getNext());
            else
                this.mFirst = lToRemoveNext;

            if(lToRemoveNext != null)
                lToRemoveNext.setPrev(lToRemove.getPrev());
            else
                this.mTail = lToRemovePrev;
        }

        lToRemove.setNext(null);
        lToRemove.setPrev(null);
        
        this.mSise--;
        return true;
    }
    
    /**
      * Method charge of printing on console keys nodes
      * Contained in the list.
      */
    @Override
    public String print() {
        String lResult = "";

        if (!this.isEmpty()) {
            
            INode<E> lTemp = this.mFirst;
            
            while (lTemp != null) {
                lResult +=  lTemp.printLabel();
                lTemp = lTemp.getNext();
            }
        }

        return lResult;
    }
    
     /**
      * Returns a String with the keys separated by last separator
      * Parameter.
      *
      * @param PSeparator Separate keys
      * @return
      */
    @Override
    public String print(String pSeparator) {
        String aux = "";
        if (!isEmpty()) 
        {
            INode<E> temp = mFirst;
            aux = temp.getData().toString();
            while (temp.getNext()!= null) 
            {
                aux = aux + pSeparator + temp.getNext().getData().toString();
                temp = temp.getNext();
            }
        }     
        return aux;
    }
    
      /**
      * Returns the number of items in the list. If the list
      * empty, return 0.
      *
      * @return Number of items in the list.
      */
    @Override
    public int size() {
        return this.mSise;
    }
    
     /**
      * Indicates whether or not the list contains elements.
      *
      * @return If you have any items.
      */
    @Override
    public boolean isEmpty() {
        return this.mFirst == null && this.mTail == null;
    }
    
      /**
      * Returns the first node in the list.
      * @return First node of the list.
      */
    @Override
    public INode<E> getFirst() {
        return this.mFirst;
    }   
    
    /**
     * Return the last node in the list
     * @return last node of the list.
     */
    @Override
    public INode<E> getLast() {
        return this.mTail;
    }
    
    /**
     * Itereate the list from the end of a node
     * @param pNode start node
     * @return prev node
     */
    public INode<E> iterateBackward(INode<E> pNode)
    {
        return pNode.getPrev();
    }
    
    /**
     * Itereate the list from the front of a node
     * @param pNode start node
     * @return next node
     */
    public INode<E> iterateForward(INode<E> pNode)
    {
        return pNode.getNext();
    }
    
    @Override
    public String toString(){
        StringBuilder lSB = new StringBuilder();
        
        for(INode lNode = this.mFirst; lNode != null; lNode = lNode.getNext()){
            lSB.append(lNode.toString());
            lSB.append(", ");
        }
        
        return lSB.toString();
    }
}
