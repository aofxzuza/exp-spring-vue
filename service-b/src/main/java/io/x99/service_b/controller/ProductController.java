package io.x99.service_b.controller;

import io.x99.service_b.model.Product;
import io.x99.service_b.model.ProductRequest;
import io.x99.service_b.service.ServiceAClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ServiceAClient serviceAClient;


    @PreAuthorize("hasRole('api')")
    @GetMapping
    ResponseEntity<?> all() {
        try {
            List<Product> users = serviceAClient.getProducts();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Throwable th) {
            LOGGER.error("Internal Error", th);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('admin-api')")
    @PostMapping
    ResponseEntity<?> newProduce(@RequestBody ProductRequest productRequest) {
        try {
            Product product = serviceAClient.addProduct(productRequest);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Throwable th) {
            LOGGER.error("Internal Error", th);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('api')")
    @GetMapping("/{id}")
    ResponseEntity<?> one(@PathVariable Long id) {
        try {
            Product product = serviceAClient.getProduct(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Throwable th) {
            LOGGER.error("Internal Error", th);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('admin-api')")
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            Product product = serviceAClient.deleteProduct(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Throwable th) {
            LOGGER.error("Internal Error", th);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
