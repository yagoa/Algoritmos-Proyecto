/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucubooks;

import Entitys.Book;
import LogicAccesLayer.Library;
import LogicAccesLayer.Search;
import Utils.Collections.Lists.IList;
import java.io.IOException;

/**
 *
 * @author yago
 */
public class UcuBooks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Inicializdo el programa...");
            System.out.println("Por favor espere.");
            
            new ConsoleManager().Start();
            
        } 
        catch (Exception ex) {
            System.out.println("Ocurrio un error en el progama.");
        }
    }
}
