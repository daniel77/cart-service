package com.wipro.danielgorski.rest;

import com.wipro.danielgorski.domain.Cart;
import com.wipro.danielgorski.domain.Product;
import com.wipro.danielgorski.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
@Api(value = "Cart Service")
public class CartController {

    @Autowired
    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @ApiOperation(value = "Create a new cart")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> createCart() {
        Cart newCart = cartService.createCart();
        return ResponseEntity.ok(newCart);
    }

    @ApiOperation(value = "Returns cart details")
    @GetMapping(path = "{cartId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> getCart(@PathVariable("cartId") Long cartId) {
        try {
            return ResponseEntity.ok(cartService.getCart(cartId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Adds products to cart")
    @PostMapping(path = "{cartId}/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@PathVariable("cartId") Long cartId, @RequestBody Product product) {
        try {
            return ResponseEntity.ok(cartService.addProduct(cartId, product));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
