/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.UcuBooksBaseEntity;
import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.INode;
import Utils.IMapper;
import java.io.IOException;

/**
 *
 * @author yago
 * @param <T>
 */
public abstract class Repository<T extends UcuBooksBaseEntity> {

    protected IMapper mMapper;
    protected IDataSourceProvider<T> mDataSource;
    protected IList<T> mEntitys;
    
    public void loadAll() throws IOException
    {
        this.mEntitys = this.mDataSource.getAll();
    }
    
    public void loadAllFull() throws IOException
    {
       this.mEntitys = this.mDataSource.getAll();
    }
    
    /**
     *
     * @return
     */
    public IList<T> getAll()
    {
        return this.mEntitys;
    }
    
    public Boolean Remove(T item)
    {
        Boolean result = false;
        if(!this.mEntitys.isEmpty())
        {
           result = this.mEntitys.delete(item.getID());
        }
        return result;
    }
    
    public T GetById (int pId)
    {
        T result = null;
        if(!this.mEntitys.isEmpty())
        {
           INode<T> node = this.mEntitys.search(pId);
           if(node != null)
           {
               result = node.getData();
           }     
        }
        return result;
    } 
       
    abstract void CSVDataSource();
}
