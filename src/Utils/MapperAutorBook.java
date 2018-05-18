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
        
        INode<String> lTempNode;  
        AutorBook lNewInstance = null;
        
        lTempNode = pPropertys.search(1);
        
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData()))
            lNewInstance = new AutorBook(Integer.parseInt(lTempNode.getData()));
        else
            return lNewInstance;
   
        lTempNode = pPropertys.search(2);
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData()))
            lNewInstance.setOtherID(Integer.parseInt(lTempNode.getData().toString()));
        
        return lNewInstance;
    }   
}
