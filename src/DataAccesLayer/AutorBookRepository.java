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
 * This is the repository class to manage all AutorBook entity typs
 * @see AutorBook
 * exentds form Repository object.
 * @author Yago Auza
 */
public class AutorBookRepository extends Repository<AutorBook> {

    public IBinaryTree<IList<Integer>> binaryTree_BookWitheAutors;
    
    /**
     * Load the public atribute binary tree book with autors, a node has book id as key and a list of autors id as value
     * @throws IOException On input error.
     * @see IOException
     */
    public void LoadBinaryTree() throws IOException{
        if(this.mEntitys == null)
            this.loadAll();
           
        if(binaryTree_BookWitheAutors == null || binaryTree_BookWitheAutors.isEmpty()){
       
            binaryTree_BookWitheAutors = new BinaryTree<IList<Integer>>();
            
            for(INode<AutorBook> lNode = mEntitys.getFirst(); lNode != null; lNode = lNode.getNext()){   
                
                AutorBook autorBook = lNode.getData();
                
                // buscar en el arbol el id del libro
                ITreeNode<IList<Integer>> bookNode = binaryTree_BookWitheAutors.search(autorBook.getID());
                
                // si no esta agregar al arbol binario como tag el id libro con una lista de ids autores
                if(bookNode == null){          
                   
                    IList<Integer> autorsIdsList = new List<>();
                    
                    autorsIdsList.add(new Node(autorBook.getOtherID(), autorBook.getOtherID()));
                    
                    binaryTree_BookWitheAutors.add(new TreeNode(autorsIdsList,autorBook.getID()));
                }
                // si esta agregar al arbol binario, tomar la lista de ids de autores del nodo y agregarle un autor mas
                else{                
                    bookNode.getData().add(new Node(autorBook.getOtherID(), autorBook.getOtherID()));
                }
            }
        }
    }
    
    /**
     * Class constuctor
     * @param pSourceType Data source type where the autor books will be obtained
     * @see SourceType
     */
    public AutorBookRepository(SourceType pSourceType){     
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
        this.mMapper = new MapperAutorBook();
        this.mDataSource = new CSVDataSourceProvider(this.mMapper, Const.CSV.Separator ,Const.Files.BookAutors);
    }
}
