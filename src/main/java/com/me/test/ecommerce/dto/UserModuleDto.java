package com.me.test.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class to store information about user and module for data transfer object.
 *
 * @author nobelina.sidabutar
 */
@Data
@AllArgsConstructor
public class UserModuleDto {

    private String moduleName;
    private int moduleOrder;
}
