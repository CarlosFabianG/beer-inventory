package com.academy.beerinventory.web.model;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="beers")
public class BeerDto implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    private String type;
    private Long quantity;
    @Column(name = "min_quantity")
    private Long minQuantity;
    private String country;

    public BeerDto(Long id, String name, String type, Long quantity, Long minQuantity, String country) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
        this.country = country;
    }

    public BeerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getQuantity() { return quantity; }

    public void setQuantity(Long quantity) { this.quantity = quantity; }

    public Long getMinQuantity() { return minQuantity; }

    public void setMinQuantity(Long minQuantity) { this.minQuantity = minQuantity; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
