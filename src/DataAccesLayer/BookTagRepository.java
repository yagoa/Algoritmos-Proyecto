/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.*;
import Utils.*;
import Utils.Collections.BinaryTree.BinaryTree;
import Utils.Collections.BinaryTree.IBinaryTree;
import Utils.Collections.BinaryTree.ITreeNode;
import Utils.Collections.BinaryTree.TreeNode;
import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.INode;
import Utils.Collections.Lists.List;
import Utils.Collections.Lists.Node;
import java.io.IOException;

/**
 * This is the repository class to manage all BookTag entity typs
 * @see BookTag
 * exentds form Repository object.
 * @author Yago Auza
 */
public class BookTagRepository extends Repository<BookTag> {
    
    public IBinaryTree<IList<Integer>> binaryTree;
    
    public void LoadBinaryTree() throws IOException{
        if(this.mEntitys == null)
            this.loadAll();
           
        if(binaryTree == null || binaryTree.isEmpty()){
       
            binaryTree = new BinaryTree<IList<Integer>>();
            
            for(INode<BookTag> lNode = mEntitys.getFirst(); lNode != null; lNode = lNode.getNext()){   
                
                BookTag bookTag = lNode.getData();
                
                // buscar en el arbol el id del tag
                ITreeNode<IList<Integer>> bookNode = binaryTree.search(bookTag.getOtherID());
                
                // si no esta agregar al arbol binario como tag el id del tag con una lista de ids libros
                if(bookNode == null){          
                   
                    IList<Integer> booksIdsList = new List<>();
                    
                    booksIdsList.add(new Node(bookTag.getID(), bookTag.getID()));
                    
                    binaryTree.add(new TreeNode(booksIdsList,bookTag.getOtherID()));
                }
                // si esta, agregar al arbol binario. tomar la lista de ids de libros del nodo y agregarle un tag mas
                else{                
                    bookNode.getData().add(new Node(bookTag.getID(), bookTag.getID()));
                }
            }
        }
    }
    
    
    
    /**
     * Class constuctor
     * @param pSourceType Data source type where the book tags will be obtained
     * @see SourceType
     */
    public BookTagRepository(SourceType pSourceType){     
        switch (pSourceType){
            case CSV:
                this.CSVDataSource();
            break;    
            default:
                System.out.println("Recurso no reconocido");     
        }
    }
        
    @Override
    protected void CSVDataSource(){
        this.mMapper = new MapperBookTag();
        this.mDataSource = new CSVDataSourceProvider(this.mMapper, Const.CSV.Separator ,Const.Files.BookTags);
    }
}
