/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucubooks;

import Entitys.Book;
import LogicAccesLayer.Library;
import Utils.Collections.Lists.IList;
import static Utils.Const.Files.Books;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yago
 */
public class UcuBooks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Compile!!");
       
        try {
            Library liv = new Library();
            liv.Init();
            
            IList<Book> books = liv.getBooks();
            
            
            
            System.out.println("Compile!!");
        } catch (IOException ex) {
            Logger.getLogger(UcuBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
