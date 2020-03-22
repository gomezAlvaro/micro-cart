package com.gomezr.microcart;

import org.springframework.data.repository.CrudRepository;

interface CartRepository extends CrudRepository<Cart, Long> {
}
