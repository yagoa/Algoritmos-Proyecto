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
public class BookRespository extends Repository<Book> {
 
    public BookRespository(SourceType pSourceType){    
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
        this.mMapper = new MapperBook();
        this.mDataSource = new CSVDataSourceProvider(this.mMapper, Const.CSV.Separator ,Const.Files.Books);

    }
}
