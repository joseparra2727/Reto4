package com.sergioarboleda.cacharrero.app.controller;

import com.sergioarboleda.cacharrero.app.model.Clone;
import com.sergioarboleda.cacharrero.app.service.CloneService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Carotobarj
 */

@RestController
@RequestMapping("/api/clone")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CloneController {
    
    @Autowired
    CloneService cloneService;
    
    
    @GetMapping("/all")
    public List<Clone> getAll(){
        return cloneService.getAll();
    }
    
    /**
     *
     * @return 
     */
    
    @GetMapping("/{id}")
    public Optional<Clone> getById(@PathVariable("id") Integer id){
        return cloneService.getById(id);
    }
    
    /**
     * 
     * @param clone 
     * @return 
     */
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone){
        return cloneService.save(clone);
    }
    
    /**
     * 
     * @param clone 
     * @return 
     */
    
    @PutMapping(path="/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone clone(@RequestBody Clone clone){
        return cloneService.update(clone);
    }
    
    /**
     * 
     * @param id 
     * @return 
     */
    
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delClon(@PathVariable Integer id){
        return cloneService.delClon(id);
    }

    /**
     *  
     * @param 
     * @return 
     */
    
    @GetMapping("/description/{description}")
    public Optional<Clone> getDescription(@PathVariable String description){
        return cloneService.getDescription(description);
    }
    
    /**
     * 
     * @param price
     * @return 
     */

    @GetMapping("/price/{price}")
    public Optional<Clone> getPrice(@PathVariable Double price){
        return cloneService.getPrice(price);
    }

}
