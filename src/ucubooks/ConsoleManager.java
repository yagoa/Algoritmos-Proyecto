/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucubooks;

import Entitys.*;
import LogicAccesLayer.Library;
import Utils.Collections.Lists.*;
import Utils.Extensions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author yago
 */
public class ConsoleManager {   
    
    private final Menu mMenu;
    private final Library mLibrary;
    private BufferedReader mInput;
    
    /**
     * Base class constructor
     * @throws IOException
     */
    public ConsoleManager() throws IOException{
        mMenu = new Menu();
        mLibrary = new Library();    
        //mLibrary.Init();
    }
    
    /**
     * Main entrance point to start the program
     * @throws IOException
     */
    public void Start() throws IOException{
        int select;
        do {
            mInput = new BufferedReader(new InputStreamReader(System.in));
            select = -1;
            System.out.println("|-----------------------------------------------|\n");
            System.out.println(mMenu.MainMenu());   
            String lUserInput =  mInput.readLine();
            
            if(Extensions.isInteger(lUserInput))
                select = Integer.parseInt(lUserInput);
            
            switch(select){
                case 1:
                    this.FindBookByYear();
                    break;
                case 2:
                    this.FindBookById();
                    break;       
                case 3:
                    this.FindByNameAndYear();
                    break;
                case 4:
                    this.FindBookByAutorAndIsbn();
                    break;
                case 5:
                    this.FindByAutorName();
                    break;
                case 6:
                    this.FindByTagName();
                    break;
                case 7:
                    this.DeleteAutor();
                    break;
                case 8:
                    System.out.println("|---------------------GRACIAS-------------------|");
                    break;
                default:
                      System.out.println("|--------INGRESE UNA OPCION VALIDA--------------|");
                break;
            }
          System.out.println("-------Precione cualquier tecla para continuar---");
          mInput.readLine();
        } while (select != 8);
    }
    
    
    private void DeleteAutor() throws IOException{
        System.out.println(mMenu.MenuAutorDelete()); 
        String lUserInput =  mInput.readLine();
         
        try {
            boolean lResult = mLibrary.RemoveAutor(lUserInput);
            if(lResult){
                System.out.println("---------------AUTOR ELIMINADO---------------");
            }
            else{
                System.out.println("-------------AUTOR NO ELIMINADO--------------");
            }
        } 
        catch (IOException ex) {
            mMenu.MenuExeption();
            System.out.println(ex.getMessage());
        }
    }
    
    private void FindByTagName() throws IOException{
        System.out.println(mMenu.MenuTagName()); 
        String lUserInput =  mInput.readLine();
         
        try {
            IList<Book> books = mLibrary.GetSearcher().BooksByTag(lUserInput);
            if(books != null && books.size() > 0){

                for(INode<Book> lNode = books.getFirst(); lNode != null; lNode = lNode.getNext()){       

                    Book lCurrent = lNode.getData();
                    System.out.println(lCurrent.toString());
                    System.out.println("-------------------------------------------------");
                } 
            }
        } 
        catch (IOException ex) {
            mMenu.MenuExeption();
            System.out.println(ex.getMessage());
        }
    }
    
    private void FindByAutorName() throws IOException{
        System.out.println(mMenu.MenuAutorName()); 
        String lUserInput =  mInput.readLine();
         
        try {
            IList<Book> books = mLibrary.GetSearcher().BooksByAutor(lUserInput);
            if(books != null && books.size() > 0){

                for(INode<Book> lNode = books.getFirst(); lNode != null; lNode = lNode.getNext()){       

                    Book lCurrent = lNode.getData();
                    System.out.println(lCurrent.toString());
                    System.out.println("-------------------------------------------------");
                } 
            }
        } 
        catch (IOException ex) {
            mMenu.MenuExeption();
            System.out.println(ex.getMessage());
        }
    }
  
    private void FindByNameAndYear() throws IOException{
        mInput = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println(mMenu.MenuBookName()); 
        String lUserInputName =  mInput.readLine();
        
        System.out.println(mMenu.MenuBookYear()); 
        String lUserInputYear =  mInput.readLine();
        
        int lYear = 9000;
        
        if(Extensions.isInteger(lUserInputYear))
        {
            lYear = Integer.parseInt(lUserInputYear);
           
            try {
                IList<Book> books = mLibrary.GetSearcher().BookByNameAndYear(lUserInputName,(short)lYear);
                if(books != null && books.size() > 0){
                    
                    for(INode<Book> lNode = books.getFirst(); lNode != null; lNode = lNode.getNext()){       

                        Book lCurrent = lNode.getData();
                        System.out.println(lCurrent.toString());
                        System.out.println("-------------------------------------------------");
                    } 
                }
            } 
            catch (IOException ex) {
                mMenu.MenuExeption();
                System.out.println(ex.getMessage());
            }
        }
        else{
            mMenu.MenuBadParameter();
        }
    }
    
    private void FindBookByYear() throws IOException{
        System.out.println(mMenu.MenuBookYear()); 
        String lUserInput =  mInput.readLine();
        int lYear = 9000;
        
        if(Extensions.isInteger(lUserInput))
        {
            lYear = Integer.parseInt(lUserInput);
           
            try {
                IList<Book> books = mLibrary.GetSearcher().BooksByYear((short)lYear);
                if(books != null && books.size() > 0){
                    
                    for(INode<Book> lNode = books.getFirst(); lNode != null; lNode = lNode.getNext()){       

                        Book lCurrent = lNode.getData();
                        System.out.println(lCurrent.toString());
                        System.out.println("-------------------------------------------------");
                    } 
                }
            } 
            catch (IOException ex) {
                mMenu.MenuExeption();
                System.out.println(ex.getMessage());
            }
        }
        else{
            mMenu.MenuBadParameter();
        }
    }
    
    private void FindBookById() throws IOException{  
        System.out.println(mMenu.MenuBookById());        
        String lUserInput =  mInput.readLine();
        int lId = -1;
        
        if(Extensions.isInteger(lUserInput))
        {
            lId = Integer.parseInt(lUserInput);
           
            try {
                INode<Book> lNode = mLibrary.getBooks().search(lId);
                if(lNode != null && lNode.getData() != null){    
                    Book lCurrent = lNode.getData();
                    System.out.println("-------------------------------------------------");     
                    System.out.println(lCurrent.toString());
          
                }
                else{
                    System.out.println("--------------LIBRO NO ENCONTRADO----------------");   
                }
            } 
            catch (Exception ex) {
                mMenu.MenuExeption();
                System.out.println(ex.getMessage());
            }
        }
        else{
            mMenu.MenuBadParameter();
        }
    }
    
    private void FindBookByAutorAndIsbn() throws IOException{
        mInput = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println(mMenu.MenuAutorName()); 
        String lUserInputAutor =  mInput.readLine();
        
        System.out.println(mMenu.MenuBookIsbn()); 
        String lUserInputISBN =  mInput.readLine();
            
        try {
            IList<Book> books = mLibrary.GetSearcher().BookByAutorAndISBN(lUserInputAutor,lUserInputISBN);
            if(books != null && books.size() > 0){

                for(INode<Book> lNode = books.getFirst(); lNode != null; lNode = lNode.getNext()){       

                    Book lCurrent = lNode.getData();
                    System.out.println(lCurrent.toString());
                    System.out.println("-------------------------------------------------");
                } 
            }
        } 
        catch (Exception ex) {
            mMenu.MenuExeption();
            System.out.println(ex.getMessage());
        }
        
    }
}
