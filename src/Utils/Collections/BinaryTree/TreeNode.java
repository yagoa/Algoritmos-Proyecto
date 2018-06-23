package Utils.Collections.BinaryTree;

import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.Node;
import java.util.LinkedList;

/**
 * @author Programacion2
 * @param <T>
 *
 */
public class TreeNode<T> implements ITreeNode<T> {

    private Comparable mTag;
    private ITreeNode mLeftSon;
    private ITreeNode mRigthSon;
    private T mData;

    /**
     * @param tag
     * @param data
     */
    @SuppressWarnings("unchecked")
    public TreeNode(T data,Comparable tag) {
        mTag = tag;
        mData = data;
    }

    @Override
    public ITreeNode getLeftSon() 
    {
        return mLeftSon;
    }

    @Override
    public ITreeNode getRigthSon() 
    {
        return mRigthSon;
    }

    /**
     * @param node
     * @return
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
     * @param tag
     * @return
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
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
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

    @Override
    public Comparable getTag() {
        return mTag;
    }


    @Override
    public T getData() 
    {
        return mData;
    }

    @Override
    public void setLeftSon(ITreeNode node) 
    {
        this.mLeftSon = node;
    }

    @Override
    public void setRigthSon(ITreeNode node) 
    {
        this.mRigthSon = node;
    }

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
