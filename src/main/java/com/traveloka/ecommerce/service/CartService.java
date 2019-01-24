package com.traveloka.ecommerce.service;

import com.traveloka.ecommerce.controller.ProductNotfoundException;
import com.traveloka.ecommerce.model.*;
import com.traveloka.ecommerce.repository.CartRepository;
import com.traveloka.ecommerce.repository.CartRepositoryCustom;
import com.traveloka.ecommerce.repository.ProductRepository;
import com.traveloka.ecommerce.request.AddToCartRequest;
import com.traveloka.ecommerce.request.RemoveCartItemRequest;
import com.traveloka.ecommerce.request.UpdateCartItemQuantityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    CartRepository cartRepository;
    CartRepositoryCustom cartRepositoryCustom;
    ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CartRepositoryCustom cartRepositoryCustom, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartRepositoryCustom = cartRepositoryCustom;
        this.productRepository = productRepository;
    }

    public void addToCart(AddToCartRequest addToCartRequest) throws Exception {
        String accountId = addToCartRequest.getAccountId();
        Product product = productRepository.findOne(addToCartRequest.getProductId());
        if(product == null){
            throw new ProductNotfoundException(addToCartRequest.getProductId());
        }
        Cart cart = cartRepositoryCustom.fetchCartByAccountId(accountId);

        List<CartItem> cartItemList = cart.getCartItemList();
        Double amountToAdd = new Double(0);
        CartItem cartItemToUpdate = null;
        for(CartItem cartItem : cartItemList){
            if(cartItem.getItem().getId().equals(product.getId())) {
                cartItemToUpdate = cartItem;
                int initialItemQuantity = cartItem.getQuantity();
                Double itemPrice = cartItem.getItem().getPrice();
                amountToAdd = itemPrice;
                cartItemToUpdate.setQuantity(initialItemQuantity + 1);
                cart.setAmountPayable(cart.getAmountPayable() + amountToAdd);
            }
        }
        if(cartItemToUpdate==null)
        {
            CartItem cartItem =new CartItem();
            cartItem.setItem(product);
            cartItem.setQuantity(addToCartRequest.getQuantity());
            cart.getCartItemList().add(cartItem);
            cart.setAmountPayable(cart.getAmountPayable() + cartItem.getQuantity()*cartItem.getItem().getPrice());
            cartRepository.save(cart);
        }
        cartRepository.save(cart);

//        CartItem cartItem =new CartItem();
//        CartItem existingItem = new CartItem();
//
//        cartItem.getItem()
//        cartItem.setItem(product);
//        cartItem.setQuantity(addToCartRequest.getQuantity());
//        cart.getCartItemList().add(cartItem);
//        cart.setAmountPayable(cart.getAmountPayable() + cartItem.getQuantity()*cartItem.getItem().getPrice());
//        cartRepository.save(cart);
    }

    public void changeQuantity(String accountId, String productId, int updatedQuantity) throws Exception {
        Cart cart = cartRepositoryCustom.fetchCartByAccountId(accountId);
        List<CartItem> cartItemList = cart.getCartItemList();
        Double amountToAdd = new Double(0);
        CartItem cartItemToUpdate = null;
        for(CartItem cartItem : cartItemList){
            if(cartItem.getItem().getId().equals(productId)){
                cartItemToUpdate = cartItem;
                int initialItemQuantity = cartItem.getQuantity();
                Double itemPrice =cartItem.getItem().getPrice();
                amountToAdd = (updatedQuantity - initialItemQuantity)*itemPrice;
                cartItem.setQuantity(updatedQuantity);
            }
        }
        if(cartItemToUpdate == null){
            throw new ProductNotfoundException(productId);
        }
        cart.setAmountPayable(cart.getAmountPayable() + amountToAdd);
        if(cartItemToUpdate != null && cartItemToUpdate.getQuantity() == 0){
            deleteItemFromCart(cart, cartItemToUpdate);
        }
        cartRepository.save(cart);
    }

    public List<CartItem> fetchAllCartItems(String accountId) {
        Cart cart = cartRepositoryCustom.fetchCartByAccountId(accountId);
        return cart.getCartItemList();
    }

    public void removeCartItem(String accountId, String productId) throws Exception {
        Cart cart = cartRepositoryCustom.fetchCartByAccountId(accountId);
        CartItem cartItemToRemove = null;
        for(CartItem cartItem : cart.getCartItemList()){
            if(cartItem.getItem().getId().equals(productId)) {
                cartItemToRemove = cartItem;
            }
        }
        if(cartItemToRemove == null){
            throw new ProductNotfoundException(productId);
        }
        cart.getCartItemList().remove(cartItemToRemove);
        cart.setAmountPayable(cart.getAmountPayable() - cartItemToRemove.getItem().getPrice()*cartItemToRemove.getQuantity());
        cartRepository.save(cart);
    }


    public void deleteItemFromCart(Cart cart, CartItem cartItem){
        cart.getCartItemList().remove(cartItem);
    }
}
