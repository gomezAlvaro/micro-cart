package com.gomezr.microcart;

import java.util.ArrayList;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CartMapper {

    public abstract CartDto toDto(Cart cart);

    @AfterMapping
    public void populateProducts(Cart cart, @MappingTarget CartDto cartDto) {
        List<ProductDto> productDtos = new ArrayList<>();
        cart.getCartProducts().forEach(cp -> {
            final Product product = cp.getCartProductPK().getProduct();
            productDtos.add(ProductDto.builder()
                      .id(product.getId())
                      .name(product.getName())
                      .quantity(cp.getQuantity())
                      .build());
        });
        cartDto.setCartProducts(productDtos);
    }
}
