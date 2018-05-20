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
 * This is the repository class to manage all Tag entity typs
 * @see Tag
 * exentds form Repository object.
 * @author Yago Auza
 */
public class TagRepository extends Repository<Tag> {

    /**
     * Class constuctor
     * @param pSourceType Data source type where the tags will be obtained
     * @see SourceType
     */
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
