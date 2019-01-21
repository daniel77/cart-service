package com.wipro.danielgorski.service;

import com.wipro.danielgorski.domain.Cart;
import com.wipro.danielgorski.domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class CartService  {

    private final CartRepository cartRepository;

    private final ProductService productRestClient;

    public CartService(CartRepository cartRepository, ProductService productRestClient) {
        this.cartRepository = cartRepository;
        this.productRestClient = productRestClient;
    }

    public Cart createCart() {
        Cart cart = Cart.builder().products(new ArrayList<>()).build();
        return cartRepository.save(cart);
    }

    public Cart getCart(Long cartId) throws Exception{
        Optional<Cart> cartOp = cartRepository.findById(cartId);

        if(!cartOp.isPresent())
            throwCardNotFoundException(cartId);

        return cartOp.get();
    }

    public Product addProduct(Long cartId, Product productToBeAdded) throws Exception{
        Product product = productRestClient.getProduct(productToBeAdded.getId());
        if(product == null) {
            throw new Exception("Product not found "+ productToBeAdded.getId());
        }
        Optional<Cart> cartOp = cartRepository.findById(cartId);

        if(!cartOp.isPresent())
            throwCardNotFoundException(cartId);

        Cart cart = cartOp.get();
        cart.getProducts().add(product);
        product.setCart(cart);

        cartRepository.save(cart);

        return product;
    }

    private void throwCardNotFoundException(Long cartId) throws Exception{
        throw new Exception("Cart Not Found " + cartId);
    }
}


