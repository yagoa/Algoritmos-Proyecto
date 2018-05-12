/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesLayer;

import Entitys.Tag;
import Utils.Const;
import Utils.MapperTag;
import Utils.SourceType;

/**
 *
 * @author yago
 */
public class TagRepository extends Repository<Tag> {

    public TagRepository(SourceType pSourceType){     
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
        this.mMapper = new MapperTag();
        this.mDataSource = new CSVDataSourceProvider(this.mMapper, Const.CSV.Separator ,Const.Files.Tags); 
    } 
}