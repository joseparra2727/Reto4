package com.sergioarboleda.cacharrero.app.repository;

import java.util.List;
import java.util.Optional;
import com.sergioarboleda.cacharrero.app.model.Order;
import com.sergioarboleda.cacharrero.app.repository.crud.OrdersCrudRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carotobarj
 */

@Repository
public class OrdersRepository {

    @Autowired
    OrdersCrudRepository ordersCrudRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     *
     * @return
     */
    public List<Order> getAll() {
        return ordersCrudRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Order> getById(Integer id) {
        return ordersCrudRepository.findById(id);
    }

    /**
     *
     * @param zone
     * @return
     */
    public List<Order> getByZone(String zone) {
        return ordersCrudRepository.findByZone(zone);
    }

    /**
     *
     * @param order
     * @return
     */
    public Order save(Order order) {
        return ordersCrudRepository.save(order);
    }

    /**
     *
     * @param status
     * @return
     */
    public List<Order> getByStatus(String status) {
        return ordersCrudRepository.findByStatus(status);
    }

    /**
     *
     * @param id
     * @return
     */
    public List<Order> getBySalesmanId(Integer id) {
        return ordersCrudRepository.findBySalesMan_Id(id);
    }

    /**
     *
     * @param registerDay
     * @param id
     * @return
     */
    public List<Order> getByDateAndId(String registerDay, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria criteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(registerDay, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(registerDay, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);
        query.addCriteria(criteria);

        List<Order> orders = mongoTemplate.find(query, Order.class);
        return orders;
    }

    /**
     *
     * @param status
     * @param id
     * @return
     */
    public List<Order> getByStatusAndId(String status, Integer id) {
        return ordersCrudRepository.findByStatusAndSalesMan_Id(status, id);
    }
}
