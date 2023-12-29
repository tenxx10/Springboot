package com.springboot.api.service.impl;

import com.springboot.api.service.ProductService;
import com.springboot.jpa.data.dao.ProductDAO;
import com.springboot.jpa.data.dto.ProductDto;
import com.springboot.jpa.data.dto.ProductResponseDto;
import com.springboot.jpa.data.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl (ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {

        Product product = productDAO.selectProduct(number);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setStock(product.getStock());
        productResponseDto.setPrice(product.getPrice());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {

        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setPrice(productDto.getPrice());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdateAt(LocalDateTime.now());


        Product savedProduct = productDAO.insertProduct(product);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setStock(product.getStock());
        productResponseDto.setPrice(product.getPrice());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {

        Product changeddProduct = productDAO.updateProductName(number,name);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(changeddProduct.getName());
        productResponseDto.setNumber(changeddProduct.getNumber());
        productResponseDto.setStock(changeddProduct.getStock());
        productResponseDto.setPrice(changeddProduct.getPrice());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {

        productDAO.deleteProduct(number);
    }


}
