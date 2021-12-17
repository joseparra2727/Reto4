package com.sergioarboleda.cacharrero.app.service;

import java.util.List;
import java.util.Optional;
import com.sergioarboleda.cacharrero.app.model.Order;
import com.sergioarboleda.cacharrero.app.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carotobarj
 */
@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    /**
     *
     * @return
     */
    public List<Order> getAll() {
        return ordersRepository.getAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Order> getById(Integer id) {
        return ordersRepository.getById(id);
    }

    /**
     *
     * @param order
     * @return
     */
    public Order save(Order order) {
        if (order.getId() == null || order.getRegisterDay() == null
                || order.getSalesMan() == null || order.getProducts() == null
                || order.getQuantities() == null) {
            return order;
        } else {
            Optional<Order> orderAux = ordersRepository.getById(order.getId());
            if (orderAux.isEmpty()) {
                return ordersRepository.save(order);
            } else {
                return order;
            }
        }
    }

    /**
     *
     * @param order
     * @return
     */

    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> auxOrder = ordersRepository.getById(order.getId());
            if (!auxOrder.isEmpty()) {
                if (order.getRegisterDay() != null) {
                    auxOrder.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getStatus() != null) {
                    auxOrder.get().setStatus(order.getStatus());
                }

                if (order.getSalesMan() != null) {
                    auxOrder.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    auxOrder.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    auxOrder.get().setQuantities(order.getQuantities());
                }

                ordersRepository.save(auxOrder.get());
                return auxOrder.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    /**
     * 
     * @param zone
     * @return 
     */
    
    public List<Order> getByZone(String zone) {
        return ordersRepository.getByZone(zone);
    }

    /**
     * 
     * @param status
     * @return 
     */
    
    public List<Order> getByStatus(String status) {
        return ordersRepository.getByStatus(status);
    }

    /**
     * 
     * @param id
     * @return 
     */
    
    public List<Order> getBySalesmanId(Integer id) {
        return ordersRepository.getBySalesmanId(id);
    }

    /**
     * 
     * @param registerDay
     * @param id
     * @return 
     */
    
    public List<Order> getByDateAndId(String registerDay, Integer id) {
        return ordersRepository.getByDateAndId(registerDay, id);
    }

    /**
     * 
     * @param status
     * @param id
     * @return 
     */
    
    public List<Order> getByStatusAndId(String status, Integer id) {
        return ordersRepository.getByStatusAndId(status, id);
    }
}
