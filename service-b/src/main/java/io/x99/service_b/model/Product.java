package io.x99.service_b.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;

}
