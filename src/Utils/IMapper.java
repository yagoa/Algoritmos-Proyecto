
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import Utils.Collections.Lists.IList;


/**
*Implements this interface to made conversion form surce entity to an object entity.
* 
* @author  Yago Auza
* @version 1.0
*/
public interface IMapper {
    
    /**
     * Conver a datasurce entity to an object entity.
     * @param pPropertys List of propertys
     * @return New ojecg entity.
     */
    public Object SourceToEntity(IList<String> pPropertys);
}
