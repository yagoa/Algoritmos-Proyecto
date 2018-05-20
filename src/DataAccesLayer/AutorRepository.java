/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.*;
import Utils.*;

/**
 * This is the repository class to manage all Autors entity typs
 * @see Autor
 * exentds form Repository object.
 * @author Yago Auza
 */
public class AutorRepository extends Repository<Autor> {
       
    /**
     * Class constuctor
     * @param pSourceType Data source type where the autors will be obtained
     * @see SourceType
     */
    public AutorRepository(SourceType pSourceType){     
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
        this.mMapper = new MapperAutor();
        this.mDataSource = new CSVDataSourceProvider(this.mMapper, Const.CSV.Separator ,Const.Files.Authors);
    }
}
