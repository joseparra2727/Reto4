package com.sergioarboleda.cacharrero.app.controller;

import java.util.List;

import com.sergioarboleda.cacharrero.app.model.Order;
import com.sergioarboleda.cacharrero.app.service.OrdersService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/order")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrdersController {
    
    
    @Autowired
    OrdersService ordersService;

    /**
     
     * @return 
     */
    @GetMapping("/all")
    public List<Order> getAll(){
        return ordersService.getAll();
    }
    
    /**
     * 
     * @param id 
     * @return 
     */
    
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id){
        return ordersService.getById(id);
    }
    
    /**
     * 
     * @param order 
     * @return 
     */
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return ordersService.save(order);
    }
    
    /**
     * 
     * @param order
     * @return 
     */
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return ordersService.update(order);
    }
    
    /**
     * 
     * @param zone
     * @return 
     */
    
    @GetMapping("/zona/{zona}")
    public List<Order> getByZone(@PathVariable("zona") String zone){
        return ordersService.getByZone(zone);
    }
    
    /**
     * 
     * @param status
     * @return 
     */
    
    @GetMapping("/state/{status}")
    public List<Order> getByStatus(@PathVariable("status") String status){
        return ordersService.getByStatus(status);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    
    @GetMapping("/salesman/{id}")
    public List<Order> getBySalesmanId(@PathVariable("id") Integer id){
        return ordersService.getBySalesmanId(id);
    }
    
    /**
     * 
     * @param registerDay
     * @param id
     * @return 
     */
    
    @GetMapping("/date/{date}/{id}")
    public List<Order> getByDateAndId(@PathVariable("date") String registerDay, @PathVariable("id") Integer id){
        return ordersService.getByDateAndId(registerDay, id);
    }
    
    /**
     * 
     * @param status
     * @param id
     * @return 
     */
    
    @GetMapping("state/{status}/{id}")
    public List<Order> getByStatusAndId(@PathVariable("status") String status, @PathVariable("id") Integer id){
        return ordersService.getByStatusAndId(status, id);
    }
}
