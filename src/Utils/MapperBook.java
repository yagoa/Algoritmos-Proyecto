/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entitys.Book;
import Utils.Collections.Lists.*;

/**
 *  Convert a CSV book representation to an object entity representation.
 *  Implments the IIMapper interface.
 *  @see IIMapper
 * @author yago auza
 */
public class MapperBook implements IMapper {

    @Override
    public Book SourceToEntity(IList<String> pPropertys) {
        INode<String> lTempNode;  
        Book lNewInstance = null; 
        
        lTempNode = pPropertys.search(1);
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData()))
            lNewInstance = new Book(Integer.parseInt(lTempNode.getData()));
        else
            return lNewInstance;
             
        lTempNode = pPropertys.search(2);
        if(lTempNode!= null)
            lNewInstance.setName(lTempNode.getData().toString());
        
        lTempNode = pPropertys.search(3);
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData()))
            lNewInstance.setYear(Short.parseShort(lTempNode.getData().toString()));
        
        lTempNode = pPropertys.search(4);
        if(lTempNode!= null && Extensions.isFloat(lTempNode.getData()))
            lNewInstance.setPoints(Float.parseFloat(lTempNode.getData().toString()));
        
        lTempNode = pPropertys.search(5);
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData()))
            lNewInstance.setCantPoints(Integer.parseInt(lTempNode.getData().toString()));
        
        lTempNode = pPropertys.search(6);
        if(lTempNode!= null)
            lNewInstance.setISBN(lTempNode.getData().toString());
        
        return lNewInstance;
    }
    
}
