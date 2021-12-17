package com.sergioarboleda.cacharrero.app.repository;


import com.sergioarboleda.cacharrero.app.model.Clone;
import com.sergioarboleda.cacharrero.app.repository.crud.CloneCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Carotobarj
 */

@Repository
public class CloneRepository {
    
    @Autowired
    CloneCrudRepository cloneCrudRepository;
    
    /**
     * 
     * @return 
     */
    
    public List<Clone> getAll(){
        return cloneCrudRepository.findAll();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    
    public Optional<Clone> getById(Integer id){
        return cloneCrudRepository.findById(id);
    }

    /**
     * 
     * @param id
     * @return 
     */
    
    public Optional<Clone> getClone(Integer id){
        return cloneCrudRepository.findById(id);
    }
    
    /**
     * 
     * @param brand
     * @return 
     */
    
    public Optional<Clone> findByBrand(String brand){
        return cloneCrudRepository.findByBrand(brand);
    }
    
    /**
     * 
     * @param clone
     * @return 
     */
    
    public Clone save(Clone clone){
        return cloneCrudRepository.save(clone);
    }
    
    /**
     * 
     * @param clone 
     */
    
    public void delClone(Clone clone){
        cloneCrudRepository.delete(clone);
    }

    /**
     * 
     * @param description
     * @return 
     */
    
    public Optional<Clone> getDescription(String description){
        return cloneCrudRepository.findByDescriptionLike(description);
    }

    /**
     * 
     * @param price
     * @return 
     */
    
    public Optional<Clone> getPrice(Double price){
        return cloneCrudRepository.findByPrice(price);
    }
}
