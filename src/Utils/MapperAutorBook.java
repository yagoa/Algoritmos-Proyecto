/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entitys.AutorBook;
import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.INode;

public class MapperAutorBook implements IMapper {

    @Override
    public AutorBook SourceToEntity(IList<String> pPropertys) {
        
        AutorBook lNewInstance = new AutorBook(Integer.parseInt(pPropertys.getFirst().getData().toString()));
        
        INode<String> lTempNode;  
        
        lTempNode = pPropertys.search(2);
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData()))
            lNewInstance.setOtherID(Integer.parseInt(pPropertys.search(2).getData().toString()));
        
        return lNewInstance;
    }   
}
