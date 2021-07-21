package com.transac.ProductsService.command.rest;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRestModel {
    private String title;
    private BigDecimal price;
    private int quantity;
}
