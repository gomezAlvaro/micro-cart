package com.gomezr.microcart;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CartProductRepositoryTest {
    @Autowired
    private CartProductRepository cartProductRepository;


    @Test
    public void findById() {
        Iterable<CartProduct> cartProducts = cartProductRepository.findAll();
        assertThat(cartProducts).hasSize(2);
        assertThat(cartProducts).extracting("cartProductPK.cart.email").containsOnly("gomezr.alvaro@gmail.com");
    }
}
