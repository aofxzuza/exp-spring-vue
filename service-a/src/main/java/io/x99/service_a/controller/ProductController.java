package io.x99.service_a.controller;

import io.x99.service_a.error.BadRequestException;
import io.x99.service_a.error.ErrorResponse;
import io.x99.service_a.error.NotFoundException;
import io.x99.service_a.model.ProductEntity;
import io.x99.service_a.model.ProductRequest;
import io.x99.service_a.service.ProductService;
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
    private ProductService productService;


    @PreAuthorize("hasRole('api')")
    @GetMapping
    ResponseEntity<?> all() {
        try {
            List<ProductEntity> users = productService.getAllProducts();
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
            ProductEntity user = productService.addProduct(productRequest.getName(), productRequest.getPrice());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Throwable th) {
            LOGGER.error("Internal Error", th);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('api')")
    @GetMapping("/{id}")
    ResponseEntity<?> one(@PathVariable Long id) {
        try {
            ProductEntity product = productService.getProductById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Throwable th) {
            LOGGER.error("Internal Error", th);
            return new ResponseEntity<>(new ErrorResponse("Internal Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('admin-api')")
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            ProductEntity product = productService.deleteProduct(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Throwable th) {
            LOGGER.error("Internal Error", th);
            return new ResponseEntity<>(new ErrorResponse("Internal Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
