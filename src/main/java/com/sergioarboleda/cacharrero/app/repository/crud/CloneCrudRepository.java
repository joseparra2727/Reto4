package com.sergioarboleda.cacharrero.app.repository.crud;

import com.sergioarboleda.cacharrero.app.model.Clone;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 
 * @author Carotobarj
 */


public interface CloneCrudRepository extends MongoRepository<Clone, Integer>{
   
    /**
     * 
     * @param brand
     * @return 
     */
    
    public Optional<Clone> findByBrand(String brand);

   /**
    * 
    * @param description
    * @return 
    */
    
    
    public Optional<Clone> findByDescriptionLike(String description);

    /**
     * 
     * @param price
     * @return 
     */
    
    
    public Optional<Clone> findByPrice(Double price);
}