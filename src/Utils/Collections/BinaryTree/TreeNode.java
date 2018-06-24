package Utils.Collections.BinaryTree;

import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.Node;

/**
 * Tree node interface to use ina binary tree
 * @author yago
 */
public class TreeNode<T> implements ITreeNode<T> {

    private Comparable mTag;
    private ITreeNode mLeftSon;
    private ITreeNode mRigthSon;
    private T mData;

    
    @SuppressWarnings("unchecked")
    public TreeNode(T data,Comparable tag) {
        mTag = tag;
        mData = data;
    }

    /**
     * Get the left child of the node.
     * @return Left Son node.
     */
    @Override
    public ITreeNode getLeftSon() 
    {
        return mLeftSon;
    }

    /**
     * Get the right child of the node.
     * @return Right Son of the node.
     */
    @Override
    public ITreeNode getRigthSon() 
    {
        return mRigthSon;
    }

    /**
     * Insert a node inside the tree.
     * @param node Element to add.
     * @return Success of the operation.
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean add(ITreeNode node) 
    {
        if (node.getTag().compareTo(mTag) < 0) 
        {
            if (mLeftSon != null) 
            {
                return getLeftSon().add(node);
            }
            else 
            {
                mLeftSon = node;
                return true;
            }
        } 
        else if (node.getTag().compareTo(mTag) > 0) 
        {
            if (mRigthSon != null) {
                return getRigthSon().add(node);
            } else {
                mRigthSon = node;
                return true;
            }
        } 
        else {
            // ya existe un elemento con la misma tag.-
            return false;
        }
    }

    /**
     * Find an item in the tree with the indicated tag.
     * @param tag from the node to search
     * @return Element found. If you can not find it, it returns null.
     */
    @Override
    public ITreeNode search(Comparable tag) {

        if (tag.equals(mTag))
        {
            return this;
        }
        else if (tag.compareTo(mTag) < 0)
        {
            if (mLeftSon != null) 
            {
                return getLeftSon().search(tag);
            } 
            else 
            {
                return null;
            }
        } 
        else if (mRigthSon != null) 
        {
            return getRigthSon().search(tag);
        } 
        else 
        {
            return null;
        }
    }

    /**
     * Get a list of elements in the tree in inorden
     * @param unaLista a list of elements
     */
    @Override
    public void inOrden(IList<T> unaLista) {
        if (mLeftSon != null) {
            mLeftSon.inOrden(unaLista);

        }
        unaLista.add(new Node(this.getData(), this.getTag()));
        if (mRigthSon!= null) {
            mRigthSon.inOrden(unaLista);
        }
    }
    
    /**
     * Get a list of elements in the tree in preorden
     * @param unaLista a list of elements
     */
    @Override
    public void preOrden(IList<T> unaLista) {
        unaLista.add(new Node(this.getData(), this.getTag()));
        if (mLeftSon != null) {
            mLeftSon.preOrden(unaLista);
        }

        if (mRigthSon != null) {
            mRigthSon.inOrden(unaLista);
        }
    }
    
    /**
     * Get a list of elements in the tree in postorden
     * @param unaLista a list of elements
     */
    @Override
    public void postOrden(IList<T> unaLista) {

        if (mLeftSon != null) {
            mLeftSon.preOrden(unaLista);
        }

        if (mRigthSon != null) {
            mRigthSon.inOrden(unaLista);
        }
        unaLista.add(new Node(this.getData(), this.getTag()));
    }

    /**
     * Get the value of the node tag.
     * @return Node Tag.
     */
    @Override
    public Comparable getTag() {
        return mTag;
    }

    /**
     * Returns the data contained in the element.
     * @return Data
     */
    @Override
    public T getData() 
    {
        return mData;
    }

    /**
     * Assigns the left son of the node.
     * @param node Element to be assigned as a left son.
     */
    @Override
    public void setLeftSon(ITreeNode node) 
    {
        this.mLeftSon = node;
    }

    /**
     * Assigns the right son of the node.
     * @param node Element to be assigned as the right child.
     */
    @Override
    public void setRigthSon(ITreeNode node) 
    {
        this.mRigthSon = node;
    }

    /**
     * Remove an item given a tag.
     * @param tag from the node to delete
     * @return deleted node
     */
    @Override
    public ITreeNode delete(Comparable tag)
    {
        if (tag.compareTo(this.getTag()) < 0) 
        {
            if (this.mLeftSon != null) {
                this.mLeftSon = mLeftSon.delete(tag);
            }
            return this;
        }

        if (tag.compareTo(this.getTag()) > 0) 
        {
            if (this.mRigthSon != null) {
                this.mRigthSon = mRigthSon.delete(tag);

            }
            return this;
        }

        return deleteNode();
    }

    private ITreeNode deleteNode() 
    {
        if (mLeftSon == null) {
            return mRigthSon;
        }

        if (mRigthSon == null) {
            return mLeftSon;
        }

        ITreeNode elHijo = mLeftSon;
        ITreeNode elPadre = this;

        while (elHijo.getRigthSon() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getRigthSon();
        }

        if (elPadre != this) {
            elPadre.setRigthSon(elHijo.getLeftSon());
            elHijo.setLeftSon(mLeftSon);
        }

        elHijo.setRigthSon(mRigthSon);
        return elHijo;
    }
    
    public String imprimir()
    {
        return (mTag.toString());
    }
}
