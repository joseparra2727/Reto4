package com.sergioarboleda.cacharrero.app.repository.crud;

import java.util.List;
import com.sergioarboleda.cacharrero.app.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


/**
 * 
 * @author Carotobarj
 */

public interface OrdersCrudRepository extends MongoRepository<Order, Integer>{
    
    /**
     * 
     * @param zone
     * @return 
     */
    
    @Query("{'salesMan.zone':?0}")
    public List<Order> findByZone(String zone);
    
    /**
     * 
     * @param status
     * @return 
     */
    
    public List<Order> findByStatus(String status);
    
    /**
     * 
     * @param id
     * @return 
     */
    
    public List<Order> findBySalesMan_Id(Integer id);
    
    /**
     * 
     * @param status
     * @param id
     * @return 
     */
    
    public List<Order> findByStatusAndSalesMan_Id(String status, Integer id);
}
