package com.project.shopapp.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 350)
    private String name;

    private float price;

    @Column(name="thumbnail", nullable = false, length = 300)
    private String thumbnail;

    @Column(name = "description", length = 300)
    private String description;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
