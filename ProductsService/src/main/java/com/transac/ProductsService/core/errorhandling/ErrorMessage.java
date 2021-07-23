package com.transac.ProductsService.core.errorhandling;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorMessage {
    private final Date timestamp;
    private final String message;
}
