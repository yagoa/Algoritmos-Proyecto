/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.*;
import Utils.*;

/**
 * This is the repository class to manage all BookTag entity typs
 * @see BookTag
 * exentds form Repository object.
 * @author Yago Auza
 */
public class BookTagRepository extends Repository<BookTag> {
    
    
    /**
     * Class constuctor
     * @param pSourceType Data source type where the book tags will be obtained
     * @see SourceType
     */
    public BookTagRepository(SourceType pSourceType){     
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
        this.mMapper = new MapperBookTag();
        this.mDataSource = new CSVDataSourceProvider(this.mMapper, Const.CSV.Separator ,Const.Files.BookTags);
    }
}
