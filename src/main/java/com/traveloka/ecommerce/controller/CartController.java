package com.traveloka.ecommerce.controller;

import com.traveloka.ecommerce.exception.ProductNotfoundException;
import com.traveloka.ecommerce.model.Cart;
import com.traveloka.ecommerce.model.CartItem;
import com.traveloka.ecommerce.model.CustomResponse;
import com.traveloka.ecommerce.model.Product;
import com.traveloka.ecommerce.repository.CartRepository;
import com.traveloka.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    CartRepository cartRepository;
    @RequestMapping(value="/addToCart",method = RequestMethod.POST)

    // this end point will add item to cart and will give error when product is null or price is less
    // then  zero or quantity is less than zero
    ResponseEntity<CustomResponse> addItemToCart(@RequestBody @Valid Product product) {
        if(product ==null || product.getPrice()<=0 || product.getQuantity()<=0)
        {
            return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(404,"INVALID PRODUCT",null));
        }
        Cart cart = cartService.addToCart(product);
        if(cart==null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(404,"PRODUCT NOT ADDED",null));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(200,"PRODUCT SUCCESSFULLY ADDED",product));
    }

    // This end point is used for placing buy order
    @RequestMapping(value="/buy",method = RequestMethod.POST)
    ResponseEntity<CustomResponse> buy(@RequestBody @Valid Product product) {
//        System.out.println(product);
        List<CartItem> productList = new ArrayList<>();
        if(product ==null || product.getPrice()<=0 || product.getQuantity()<=0 || product.getProductName()==null || product.getPrice()==null || product.getQuantity()==null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(404,"INVALID PRODUCT",null));
        }
        product.setQuantity(1);
        CartItem cartItem =new CartItem();
        cartItem.setItem(product);
        productList.add(cartItem);
        Cart cart = new Cart();
        cart.setAmountPayable(product.getPrice());
        cart.setAccountId("");
        cart.setId("");
        cart.setCartItemList(productList);
        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(200,"PRODUCT SUCCESSFULLY ADDED",cart));
    }

    // This end point is used to update the quantity of a product present in the cart
    @RequestMapping(value="/updateQuantity",method = RequestMethod.POST)
    ResponseEntity<CustomResponse> updateCartItem(@RequestBody @Valid Product product) {
        if(product ==null || product.getPrice()<=0 || product.getQuantity()<=0 || product.getProductName()==null || product.getPrice()==null || product.getQuantity()==null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(404,"INVALID PRODUCT",null));
        }
        try {
            Cart cart = cartService.changeQuantity(product);
            if(cart==null)
            {
                return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(404,"PRODUCT QUANTITY NOT UPDATED",null));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(200,"QUANTITY SUCCESSFULLY ADDED",product));
        }
        catch (ProductNotfoundException e) {
            return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(404, "PRODUCT NOT FOUND ID : " + product.getProductId(), null));
        }
    }

    // This end point is used to fetch all the items present in the cart
    @RequestMapping(value="",method = RequestMethod.GET)
    public Cart getAllCartItems() {
        return cartService.fetchAllCartItems();
    }

    // This end point is used to remove a item present in the cart
    @RequestMapping(value="/removeCartItem/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> removeCartItem(@PathVariable @Valid String id) {
        try{
            Cart cart = cartService.removeCartItem(id);
            if(cart==null)
            {
                return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(404,"PRODUCT NOT REMOVED!!",null));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(200,"PRODUCT REMOVED SUCCESSFULLY",cart));
        }
        catch(ProductNotfoundException e){
            return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(404,"PRODUCT NOT FOUND ID : "+ id,null));
        }

    }

    // This end point is used to empty the cart
    @RequestMapping(value="/emptyCart",method = RequestMethod.DELETE)
    public void removeCartItem() {
        cartRepository.deleteAll();
    }

}