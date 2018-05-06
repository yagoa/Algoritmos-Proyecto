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
 *
 * @author yago
 */
public class MapperBookTag implements IMapper {

    @Override
    public BookTag SourceToEntity(IList<String> pPropertys) {
        
        BookTag lNewInstance = new BookTag(Integer.parseInt(pPropertys.getFirst().getData().toString()));
        
        INode<String> lTempNode;  
        
        lTempNode = pPropertys.search(2);
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData()))
            lNewInstance.setOtherID(Short.parseShort(pPropertys.search(2).getData().toString()));
        
        return lNewInstance;
    }   
}