package com.traveloka.ecommerce.controller;

import com.sun.istack.internal.NotNull;
import com.traveloka.ecommerce.repository.CartRepository;
import com.traveloka.ecommerce.request.AddToCartRequest;
import com.traveloka.ecommerce.model.CartItem;
import com.traveloka.ecommerce.request.RemoveCartItemRequest;
import com.traveloka.ecommerce.request.UpdateCartItemQuantityRequest;
import com.traveloka.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    CartRepository cartRepository;

    @RequestMapping(value="/addItemToCart",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> addItemToCart(@RequestBody @Valid AddToCartRequest addToCartRequest) throws Exception {

        cartService.addToCart(addToCartRequest);
        return new ResponseEntity("Product added successfully", HttpStatus.OK);
    }

    @RequestMapping(value="/updateQuantity",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCartItem(@RequestBody @Valid UpdateCartItemQuantityRequest request) throws Exception {
        cartService.changeQuantity(request.getAccountId(), request.getProductId(), request.getQuantity());
        return new ResponseEntity("Product Quantity updated successfully", HttpStatus.OK);

    }

//    @RequestMapping(value="/getAllCartItems",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public List<CartItem> getAllCartItems(@Valid @NotNull @PathVariable String id) {
        String accountId =id;
        return cartService.fetchAllCartItems(accountId);
    }

    @RequestMapping(value="/removeCartItem/acc01/{id}",method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> removeCartItem(@PathVariable @Valid String id) throws Exception {
        String accountId = "acc01";
        cartService.removeCartItem(accountId,id);
        return new ResponseEntity("Product added succcessfully", HttpStatus.OK);

    }

}