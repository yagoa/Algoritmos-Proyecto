/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucubooks;

/**
 *
 * @author yago
 */
public class Menu {
    
    /**
     * Create the main manu
     * @return string of with the main menu
     */
    public String MainMenu(){
        StringBuilder lSB = new StringBuilder();
        lSB.append("|          MENU DE OPCIONES UCU BOOKS           |\n");
        lSB.append("|   SELECIONE UNA DE LAS SIGUIENTES OPCIONES    |\n");
        lSB.append("|-----------------------------------------------|\n");
        lSB.append("|   Opciones:                                   |\n");
        lSB.append("|        [1]. Mostrar ultimas ediciones.        |\n");
        lSB.append("|        [2]. Mostrar informacion detallada.    |\n");
        lSB.append("|        [3]. Buscar por nombre y año.          |\n");
        lSB.append("|        [4]. Buscar por autor y ISBN.          |\n");
        lSB.append("|        [5]. Buscar por autor                  |\n");
        lSB.append("|        [6]. Buscar por tag                    |\n");
        lSB.append("|        [7]. Eliminar autor                    |\n");
        lSB.append("|        [8]. Salir                             |\n");
        return lSB.toString();
    }
    
    /**
     * Menu option used to notify the user to insert an unique book indetiffier
     * @return String menu result
     */
    public String MenuBookById(){
         StringBuilder lSB = new StringBuilder();
         lSB.append("|      POR FAVOR INGRESE EL ID DEL LIBRO       |\n");
         return lSB.toString();
    }
    
    /**
     * Menu option used to notify the user to insert an the publication year of books
     * @return String menu result
     */
    public String MenuBookYear(){
         StringBuilder lSB = new StringBuilder();
         lSB.append("|          POR FAVOR INGRESE UN AÑO:            |\n");
         return lSB.toString();
    }
    
    /**
     * Menu option used to notify the user to insert a book ISBN
     * @return String menu result
     */
    public String MenuBookIsbn(){
         StringBuilder lSB = new StringBuilder();
         lSB.append("|       POR FAVOR INGRESE EL ISBN O ISBN 13     |\n");
         return lSB.toString();
    }
    
    /**
     * Menu option used to notify the user that he insert a bad input
     * @return String menu result
     */
    public String MenuBadParameter(){
         StringBuilder lSB = new StringBuilder();
         lSB.append("|      POR FAVOR INGRESE UN VALOR CORRECTO      |\n");
         return lSB.toString();
    }
    
    /**
     * Menu option used to notify the user that an exeption was throw
     * @return String menu result
     */
    public String MenuExeption(){
         StringBuilder lSB = new StringBuilder();
         lSB.append("|              OCURRIO UNA EXEPCION              |\n");
         return lSB.toString();
    }
    
    /**
     * Menu option used to notify the user to insert a book name
     * @return String menu result
     */
    public String MenuBookName(){
         StringBuilder lSB = new StringBuilder();
         lSB.append("|   POR FAVOR INGRESE EL NOMBRE DEL LIBRO:    |\n");
         return lSB.toString();
    }
   
    /**
     * Menu option used to notify the user to insert an autor name
     * @return String menu result
     */
    public String MenuAutorName(){
         StringBuilder lSB = new StringBuilder();
         lSB.append("|   POR FAVOR INGRESE EL NOMBRE DEL AUTOR     |\n");
         return lSB.toString();
    }
    
    /**
     * Menu option used to notify the user to insert a tag name
     * @return String menu result
     */
    public String MenuTagName(){
         StringBuilder lSB = new StringBuilder();
         lSB.append("|   POR FAVOR INGRESE EL NOMBRE DEL TAG       |\n");
         return lSB.toString();
    }
    
    /**
     * Menu option used to notify the user to insert a autor name to delete
     * @return String menu result
     */
    public String MenuAutorDelete(){
         StringBuilder lSB = new StringBuilder();
         lSB.append("|ADVETENCIA: SE ELIMINARAN TODOS LOS LIBROS RELACIONADOS AL AUTOR|\n");
         return lSB.toString();
    }
}
