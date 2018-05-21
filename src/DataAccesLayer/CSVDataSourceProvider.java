/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Utils.*;
import Utils.Collections.Lists.IList;
import Utils.Collections.Lists.List;
import Utils.Collections.Lists.Node;


/**
 * Use this class manage data from a CSV file. 
 * @author Yago Auza
 * @param <T> Entity Type to map.
 */
public class CSVDataSourceProvider<T> implements IDataSourceProvider {

    /*CLASS ATRIBUTES*/  
    private final String mSeparator;
    private final String mFilePath;
    private final IMapper mMapTo;
 
    /**
     * Base constructor for the DataSoure Provider
     * @param pMapTo IMapper instance to convert the datasource data to a know entity.
     * @param pSeparator CSV delimitation string
     * @param pFilePath  where  the file is located.
     */
    public CSVDataSourceProvider(IMapper pMapTo ,String pSeparator, String pFilePath){
        this.mSeparator = pSeparator;
        this.mFilePath = pFilePath;
        this.mMapTo = pMapTo;
    }
    
     
    /*CLASS METHODS*/
    
    /**
     * This method is used to get all data form the data source.
     * mapped to the correct entity.
     * @return a generic IList of mapped objects from the datasurce.
     * @throws IOException I/O Exception
     * @see IOException
     * @throws FileNotFoundException When the file was not found
     * @see FileNotFoundException
     * @throws NullPointerException When object has not instance
     * @see NullPointerException
     */
    @Override
    public IList<T> getAll() throws IOException, FileNotFoundException, NullPointerException {
        IList<T> lObjectList = null;
        String lCurrentLine;
        
        if(this.mSeparator == null || this.mSeparator.equals(""))
            throw new NullPointerException("Separator can't be null or empty.");
        
        BufferedReader lBuferReder = this.readCSVFile();
        try
        {
        if(lBuferReder != null){
            lObjectList = new List<>();
            
            while ((lCurrentLine = lBuferReder.readLine()) != null){

                int lPropertyPosition = 1;
                IList<String> lPropertysString = new List<>();

                for(String lProperty : lCurrentLine.split("\\"+this.mSeparator)){

                    lPropertysString.add(new Node<>(lProperty, lPropertyPosition));           
                    lPropertyPosition++;
                }

                Object lEntity  = this.mMapTo.SourceToEntity(lPropertysString);
                if(lEntity!= null){
                    Comparable lKey = Integer.parseInt(lPropertysString.getFirst().getData().replaceAll("\"", ""));
                    lObjectList.add(new Node(lEntity, lKey));
                }
            }
        }
        }
        catch(IOException | NumberFormatException  ex)
        {
            System.out.println(lObjectList.size());
        }
        return lObjectList;
    }
           
    /**
     * this private method is used to get a buffer reder to reed the CSV File
     * @return BufferedReader of CSV file.
     * @throws FileNotFoundException
     * @see FileNotFoundException
     * @throws NullPointerException 
     * @see NullPointerException
     */
    private BufferedReader readCSVFile() throws FileNotFoundException, NullPointerException {
        if(this.mFilePath != null && this.mFilePath != ""){
            BufferedReader lBuferReder = null;   
            lBuferReder = new BufferedReader(new FileReader(this.mFilePath));  
            return lBuferReder;
        }
        else
            throw new NullPointerException("File Path can't be null or empty.");
    }
}
