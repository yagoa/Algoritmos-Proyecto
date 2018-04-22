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
 *
 * @author yago
 */
public class MapperTag implements IMapper {

    @Override
    public Object SourceToEntity(IList<String> pPropertys) {
        
        Tag lNewInstance = new Tag(Integer.parseInt(pPropertys.getFirst().getData().toString()));
        
        INode<String> lTempNode = pPropertys.search(1);     
        
        lTempNode = pPropertys.search(2);
        if(lTempNode!= null)
            lNewInstance.setTagName(pPropertys.search(2).getData().toString());
        
        return lNewInstance;
    }
    
}