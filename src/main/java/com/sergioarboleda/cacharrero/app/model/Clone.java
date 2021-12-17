package com.sergioarboleda.cacharrero.app.model;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Carotobarj
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Document(collection="clone")

public class Clone {
    
    @Id
    private Integer id;
    private String brand;
    private String procesor;
    private String os;
    private String description;
    private String memory;
    private String hardDrive;
    private Boolean availability = true;
    private Double price;
    private Integer quantity;
    private String photography;
}
