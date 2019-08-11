package com.me.test.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class to store information about response error for data transfer object.
 *
 * @author nobelina.sidabutar
 */
@Data
@AllArgsConstructor
public class ResponseErrorDto {

    private String error;
    private Throwable exception;
}
