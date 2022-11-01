package io.x99.service;

import io.x99.error.BadRequestException;
import io.x99.error.NotFoundException;
import io.x99.model.ProductEntity;
import io.x99.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProducts() {
        LOGGER.debug("Get all products");
        Iterable<ProductEntity> iterable = productRepository.findAll();
        return Streamable.of(iterable).toList();
    }

    public ProductEntity getProductById(Long id) {
        LOGGER.debug("Get product by id {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id is not found"));
    }

    public ProductEntity addProduct(String name, BigDecimal price) {
        if (name == null) {
            throw new BadRequestException("name doesn't exist");
        }
        if (price == null) {
            throw new BadRequestException("price doesn't exist");
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("price is less than 0");
        }
        LOGGER.debug("Add new product with name {} price {}", name, price);
        return productRepository.save(new ProductEntity(null, name, price));
    }

    public ProductEntity deleteProduct(Long id) {
        LOGGER.debug("Delete product by id {}", id);
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id is not found"));
        productRepository.delete(product);
        return product;
    }
}
