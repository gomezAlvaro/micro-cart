package com.gomezr.microcart;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class CartController {
    private CartService cartService;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/cart/{id}")
    public CartDto getCart(@PathVariable Long id) {
        return cartService.getCart(id);
    }
}
