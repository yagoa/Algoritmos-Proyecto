/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.*;
import Utils.*;

/**
 * This is the repository class to manage all AutorBook entity typs
 * @see AutorBook
 * exentds form Repository object.
 * @author Yago Auza
 */
public class AutorBookRepository extends Repository<AutorBook> {
      
    /**
     * Class constuctor
     * @param pSourceType Data source type where the autor books will be obtained
     * @see SourceType
     */
    public AutorBookRepository(SourceType pSourceType){     
        switch (pSourceType){
            case CSV:
                this.CSVDataSource();
            break;    
            default:
                System.out.println("Recurso no reconocido");     
        }
    }
        
    @Override
    protected void CSVDataSource(){
        this.mMapper = new MapperAutorBook();
        this.mDataSource = new CSVDataSourceProvider(this.mMapper, Const.CSV.Separator ,Const.Files.BookAutors);
    }
}
