package Utils.Collections.Lists;

import Utils.Collections.IIterable;
import Utils.Collections.LinkedListIterator;


/**
* Simple linked list class representation , implements IList.
* @see IList
* @author  Yago Auza
* @version 1.0
*/
public class List<E> implements IList<E> {

    private INode<E> mFirst;
    private INode<E> mLast;
    private int mSise;

    /**
     * Base class constructor.
     */
    public List() {
        this.mFirst = null;
        this.mLast = null;
        this.mSise = 0;
    }

    /**
     * Full class contructor
     * @param pNode First list node.
     */
    public List(INode<E> pNode) {
        this.mFirst = pNode;
        this.mLast = pNode;
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
            this.mLast = pNewNode;
        }
        else {
            this.mLast.setNext(pNewNode);
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
        INode<E> result = null;      
        if (!isEmpty()) 
        {
            INode<E> aux = mFirst;
            while (aux != null)
            {
                if (aux.getLabel().equals(key)) 
                {
                    return aux;
                }
                aux = aux.getNext();
            }
        }     
        return result;
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
        
        if (mFirst.getNext() == null) 
        {
            if (mFirst.getLabel().equals(pKey)) 
            {
                mFirst = null;
                mLast = null;
                this.mSise--;
                return true;
            }
        }
        INode<E> aux = mFirst;
        if (aux.getLabel().compareTo(pKey) == 0) 
        {
            //Eliminamos el primer elemento
            INode<E> temp1 = aux;
            INode<E> temp = aux.getNext();
            mFirst = temp;
            this.mSise--;
            return true;
        }
        while (aux.getNext()!= null) 
        {
            if (aux.getNext().getLabel().equals(pKey)) 
            {
                if(mLast.getLabel().equals(pKey))
                {
                    mLast = aux;
                }
                
                INode<E> temp = aux.getNext();
                aux.setNext(temp.getNext());
                this.mSise--;
                return true;
            }
            aux = aux.getNext();
        }
        return false;
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
        return this.mFirst == null && this.mLast == null;
    }
    
      /**
      * Returns the first node in the list.
      *
      * @return First node of the list.
      */
    @Override
    public INode<E> getFirst() {
        return this.mFirst;
    }
    
    /** 
     * Returns an iterator for the list.
     * @return Iterable instance. 
     */
    @Override
    public IIterable<E> iterator(){
        return new LinkedListIterator(this.mFirst);
    }
    
    @Override
    public String toString(){
        StringBuilder lSB = new StringBuilder();
        IIterable<E> lIterate = this.iterator();
        
        
        while(lIterate.hasNext()){
            lSB.append(lIterate.next().toString());
            lSB.append(", ");
        }
        return lSB.toString();
    }
}
