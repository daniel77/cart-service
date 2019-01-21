package com.wipro.danielgorski.service;

import com.wipro.danielgorski.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(name="products", url="https://product-service.apps.dev.pcf-aws.com")
public interface ProductService {
    @RequestMapping(method = RequestMethod.GET, value = "products")
    List<Product> getProducts();

    @RequestMapping(method = RequestMethod.GET, value = "products/{id}")
    Product getProduct(@PathVariable("id") Long id);

}

