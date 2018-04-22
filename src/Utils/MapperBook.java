/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entitys.Book;
import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.INode;

/**
 *
 * @author yago
 */
public class MapperBook implements IMapper {

    @Override
    public Object SourceToEntity(IList<String> pPropertys) {
        Book lNewInstance = new Book(Integer.parseInt(pPropertys.getFirst().getData().toString()));
        
        INode<String> lTempNode = pPropertys.search(1);     
        
        lTempNode = pPropertys.search(2);
        if(lTempNode!= null)
            lNewInstance.setName(pPropertys.search(2).getData().toString());
        
        lTempNode = pPropertys.search(3);
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData()))
            lNewInstance.setYear(Short.parseShort(pPropertys.search(3).getData().toString()));
        
        lTempNode = pPropertys.search(4);
        if(lTempNode!= null && Extensions.isFloat(lTempNode.getData()))
            lNewInstance.setPoints(Float.parseFloat(pPropertys.search(4).getData().toString()));
        
        lTempNode = pPropertys.search(5);
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData()))
            lNewInstance.setCantPoints(Integer.parseInt(pPropertys.search(5).getData().toString()));
        
        lTempNode = pPropertys.search(6);
        if(lTempNode!= null)
            lNewInstance.setISBN(pPropertys.search(6).getData().toString());
        
        return lNewInstance;
    }
    
}
