package com.wipro.danielgorski.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long internalId;

    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "COST")
    private double cost;

    @JsonIgnore
    @ManyToOne
    private Cart cart;

}
