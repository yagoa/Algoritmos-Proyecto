/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entitys.Autor;
import Entitys.Book;
import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.INode;

/**
 *
 * @author yago
 */
public class MapperAutor implements IMapper {

    @Override
    public Autor SourceToEntity(IList<String> pPropertys) {
        
        Autor lNewInstance = new Autor(Integer.parseInt(pPropertys.getFirst().getData().toString()));
              
        INode<String> lTempNode = pPropertys.search(2);
        if(lTempNode!= null)
            lNewInstance.setName(pPropertys.search(2).getData().toString());
        
        return lNewInstance;
    }
    
}
