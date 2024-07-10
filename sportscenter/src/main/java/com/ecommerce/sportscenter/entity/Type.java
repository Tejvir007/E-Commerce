package com.ecommerce.sportscenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="Type")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Type {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column (name="name")
    private String name;
    @OneToMany(mappedBy = "type",fetch = FetchType.LAZY)
    private List<Product> products;
}
