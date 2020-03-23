package com.gomezr.microcart;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {
    private CartRepository cartRepository;
    private CartMapper cartMapper;


    public CartDto getCart(Long id) {
        return cartMapper.toDto(cartRepository.findById(id).get());
    }
}
