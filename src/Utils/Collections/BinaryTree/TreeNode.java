package Utils.Collections.BinaryTree;

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
    public TreeNode(Comparable tag, T data) {
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

        if (tag.equals(tag))
        {
            return this;
        }
        else if (tag.compareTo(tag) < 0)
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
    public String inOrden() 
    {
        StringBuilder tempStr = new StringBuilder();
        if (mLeftSon != null) 
        {
            tempStr.append(getLeftSon().inOrden());
            tempStr.append("-");
        }
        
        tempStr.append(imprimir());
        
        if (mRigthSon != null) 
        {
            tempStr.append("-");
            tempStr.append(getRigthSon().inOrden());
        }

        return tempStr.toString();
    }

    /**
     * @return recorrida en preOrden del subArbol que cuelga del elemento actual
     */
    public String preOrden() 
    {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(imprimir());
        
        if (mLeftSon != null) 
        {
            tempStr.append("-");
            tempStr.append(getLeftSon().preOrden());
        }
        
        if (mRigthSon != null) 
        {
            tempStr.append("-");
            tempStr.append(getRigthSon().preOrden());
        }
        return tempStr.toString();
    }

    /**
     * @return recorrida en postOrden del subArbol que cuelga del elemento
     * actual
     */
    public String postOrden() 
    {
        StringBuilder tempStr = new StringBuilder();
        if (mLeftSon != null)
        {
            tempStr.append(getLeftSon().postOrden());
            tempStr.append("-");
        }
        if (mRigthSon != null)
        {
            tempStr.append(getRigthSon().postOrden());
            tempStr.append("-");
        }
        
        tempStr.append(imprimir());
        return tempStr.toString();
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
