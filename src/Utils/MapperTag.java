/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entitys.Tag;
import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.INode;

/**
 *  Convert a CSV tag representation to an object entity representation.
 *  Implments the IIMapper interface.
 *  @see IIMapper
 * @author yago auza
 */
public class MapperTag implements IMapper {

    @Override
    public Tag SourceToEntity(IList<String> pPropertys) {
             
        INode<String> lTempNode;  
        Tag lNewInstance = null; 
        
        lTempNode = pPropertys.search(1);
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData().replace("\"", "")))
            lNewInstance = new Tag(Integer.parseInt(lTempNode.getData().replace("\"", "")));
        else
            return lNewInstance;
            
        lTempNode = pPropertys.search(2);     
        if(lTempNode!= null)
            lNewInstance.setTagName(lTempNode.getData().replace("\"", ""));
        
        return lNewInstance;
    }
    
}