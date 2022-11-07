package io.x99.service_b.service;

import io.x99.service_b.model.Product;
import io.x99.service_b.model.ProductRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "serviceA", url = "${service-a.url}")
public interface ServiceAClient {

    @RequestMapping(method = RequestMethod.GET, value = "/product")
    List<Product> getProducts();

    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    Product getProduct(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    Product addProduct(ProductRequest request);

    @RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
    Product deleteProduct(@PathVariable Long id);

}
