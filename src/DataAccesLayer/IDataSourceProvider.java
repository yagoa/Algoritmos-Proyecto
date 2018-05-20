/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Utils.Collections.Lists.IList;
import java.io.IOException;
import java.io.FileNotFoundException;


/**
*Implements this interface to achieve an abstraction about the origin of dats you want to consume.
* 
* @author  Yago Auza
* @version 1.0
* @param <T> Generic Entity to map.
*/
public interface IDataSourceProvider <T> {
    /**
   * This method is used to get all data form the data source.
   * mapped to the correct entity.
   * @return A generic IList of mapped objects from the datasurce.
   * @throws IOException On input error.
   * @see IOException
   * @throws FileNotFoundException when the datasource not exist.
   * @see FileNotFoundException
   */
    public IList<T> getAll() throws IOException, FileNotFoundException;
}
