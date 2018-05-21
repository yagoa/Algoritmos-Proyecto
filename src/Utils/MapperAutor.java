/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entitys.Autor;
import Utils.Collections.Lists.*;

/**
 *  Convert a CSV autor representation to an object entity representation.
 *  Implments the IIMapper interface.
 *  @see IMapper Mapper interface
 * @author yago auza
 */
public class MapperAutor implements IMapper {

    @Override
    public Autor SourceToEntity(IList<String> pPropertys) {
        
        INode<String> lTempNode;  
        Autor lNewInstance = null;
        
        lTempNode = pPropertys.search(1);
        if(lTempNode!= null && Extensions.isInteger(lTempNode.getData()))
            lNewInstance = new Autor(Integer.parseInt(lTempNode.getData()));
        else
            return lNewInstance;
                 
        lTempNode = pPropertys.search(2);
        if(lTempNode!= null)
            lNewInstance.setName(lTempNode.getData().toString());
        
        return lNewInstance;
    }
    
}
