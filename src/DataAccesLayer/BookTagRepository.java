/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.*;
import Utils.*;

/**
 *
 * @author yago
 */
public class BookTagRepository extends Repository<BookTag> {
    
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
