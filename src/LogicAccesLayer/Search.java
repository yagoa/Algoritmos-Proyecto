/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicAccesLayer;

import DataAccesLayer.Repository;

/**
 *
 * @author yago
 */
public class Search {
    
    private final Repository BooksRepo;
    private final Repository TagsRepo;
    private final Repository AutorsRepo;
    private final Repository AutorBooksRepo;
    private final Repository BookTagsRepo;
    
    public Search(Repository pBooksRepo,Repository pTagsRepo,Repository pAutorsRepo,Repository pAutorBooksRepo,Repository pBookTagsRepo )
    {
        this.TagsRepo = pTagsRepo;
        this.AutorsRepo = pAutorsRepo;
        this.BooksRepo = pBooksRepo;
        this.AutorBooksRepo = pAutorBooksRepo;
        this.BookTagsRepo = pBookTagsRepo;
    }
}
