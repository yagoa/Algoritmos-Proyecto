/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entitys.BookTag;
import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.INode;

/**
 *  Convert a CSV books tags representation to an object entity representation.
 *  Implments the IIMapper interface.
 *  @see IMapper Mapper interface
 * @author yago auza
 */
public class MapperBookTag implements IMapper {

    @Override
    public BookTag SourceToEntity(IList<String> pPropertys) {
        
        INode<String> lTempNode;  
        BookTag lNewInstance = null;
        
        lTempNode = pPropertys.search(1);
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData()))
            lNewInstance = new BookTag(Integer.parseInt(lTempNode.getData()));
        else
            return lNewInstance;
   
        lTempNode = pPropertys.search(2);
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData()))
            lNewInstance.setOtherID(Integer.parseInt(lTempNode.getData().toString()));
        
        return lNewInstance;
    }   
}