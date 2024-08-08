package com.ecommerce.sportscenter.service;

import com.ecommerce.sportscenter.entity.Product;
import com.ecommerce.sportscenter.model.ProductResponse;
import com.ecommerce.sportscenter.repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.core.convert.TypeDescriptor.map;


@Data
@Log4j2
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public ProductResponse getProductById(Integer productId){

        log.info("fetching products by productId {}",productId);
        Product product=productRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("Product with given id doesn't exist"));
        ProductResponse productResponse=convertToProductResponse(product);
        log.info("Fetched product by product id: {}", productId);
        return productResponse;
    }
    @Override
    public List<ProductResponse> getProducts(){
        log.info("Fetching prodcuts");
        //Fetching from DB
        List<Product> productList=productRepository.findAll();
        //Map to productResponse
        List<ProductResponse> productResponses=productList.stream()
                .map(this::convertToProductResponse)
                .collect(Collectors.toList());
        log.info("Fetched All products");
        return productResponses;

    }
    private ProductResponse convertToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .pictureUrl(product.getPictureUrl())
                .productBrand(product.getBrand().getName())
                .productType(product.getType().getName())
                .build();

    }

}
