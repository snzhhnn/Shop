package com.fialka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_in_order")
public class ProductInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int quantity;
    private double totalCost;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Ordering order;
}