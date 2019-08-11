package com.me.test.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Class to store information about user for data transfer object.
 *
 * @author nobelina.sidabutar
 */
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private List<UserModuleDto> modules;

    /**
     * Instantiates a new User dto.
     *
     * @param modules the modules
     */
    public UserDto(List<UserModuleDto> modules) {
        this.modules = modules;
    }

    /**
     * Instantiates a new User dto.
     *
     * @param id    the id
     * @param name  the name
     * @param email the email
     */
    public UserDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
