/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author yago
 */
public class Extensions {
    
    public static boolean isInteger(String pInput ){
       try{
          Integer.parseInt( pInput );
          return true;
       }
       catch(Exception er){
          return false;
       }
    }
    
    public static boolean isFloat(String pInput ){
       try{
          Float.parseFloat(pInput);
          return true;
       }
       catch(Exception er){
          return false;
       }
    }
}
