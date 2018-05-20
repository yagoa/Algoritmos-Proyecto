/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 * Utility class for extension methods
 * @author yago auza
 */
public class Extensions {
    
    /**
     * Check if a string value is a integer
     * @param pInput string to check
     * @return true or false
     */
    public static boolean isInteger(String pInput ){
       try{
          Integer.parseInt( pInput );
          return true;
       }
       catch(NumberFormatException er){
          return false;
       }
    }
    
    /**
     * Check if the string value is a float
     * @param pInput string to check
     * @return true or false
     */
    public static boolean isFloat(String pInput ){
       try{
          Float.parseFloat(pInput);
          return true;
       }
       catch(NumberFormatException er){
          return false;
       }
    }
}
