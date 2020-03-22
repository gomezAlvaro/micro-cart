package com.gomezr.microcart;

import org.springframework.data.repository.CrudRepository;

interface CartProductRepository extends CrudRepository<CartProduct, CartProductPK> {
}
