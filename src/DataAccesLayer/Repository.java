/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.UcuBooksBaseEntity;
import Utils.Collections.BinaryTree.IBinaryTree;
import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.INode;
import Utils.IMapper;
import java.io.IOException;

/**
 * This is a base class with generic and common methods to all repositorys
 * @author Yago Auza
 * @param <T> Entity Type.
 */
public abstract class Repository<T extends UcuBooksBaseEntity> {

    protected IMapper mMapper;
    protected IDataSourceProvider<T> mDataSource;
    protected IList<T> mEntitys;
    
    /**
     * Read all data form a data source and load it in the class for future use
     * @throws IOException I/O Exception
     * @see IOException
     */
    public void loadAll() throws IOException{
        this.mEntitys = this.mDataSource.getAll();
    }
    
    /**
     * Read all data from data source and load all data and his dependecys in this class for future use
     * @throws IOException I/O Exception
     * @see IOException
     */
    public void loadAllFull() throws IOException{
       this.mEntitys = this.mDataSource.getAll();
    }
    
    /**
     * Get a list of all entitys in the repos or null if they do not exist.
     * @throws IOException I/O Exception
     * @see IOException
     * @return instance of IList with entitys or null
     */
    public IList<T> getAll() throws IOException{
        if(this.mEntitys == null)
            this.loadAll();
            
        return this.mEntitys;
    }
    
    /**
     * Delete a entity form the repository 
     * @param item Entity to be remove
     * @return True if entity was removed
     */
    public Boolean Remove(T item){
        Boolean result = false;
        if(!this.mEntitys.isEmpty())
        {
           result = this.mEntitys.delete(item.getID());
        }
        return result;
    }
    
    /**
     * Get a entity instance form the repository if exist.
     * @param pId Entity unique identifier
     * @return Enitity if exist or null
     */
    public T GetById (int pId){
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
