package com.gomezr.microcart;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void findById() {
        Cart cart = cartRepository.findById(1L).get();
        assertThat(cart.getCartProducts()).hasSize(2);
        assertThat(cart.getEmail()).isEqualTo("gomezr.alvaro@gmail.com");
    }
}
