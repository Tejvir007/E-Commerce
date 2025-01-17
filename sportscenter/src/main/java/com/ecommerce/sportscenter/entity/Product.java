package com.ecommerce.sportscenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column (name="Name")
    private String name;
    @Column (name="Description")
    private String description;
    @Column (name="Price")
    private Long price;
    @Column (name="PictureUrl")
    private String pictureUrl;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ProductBrandId", referencedColumnName = "Id")
    private Brand brand;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ProductTypeId", referencedColumnName = "Id")
    private Type type;


}
