package com.me.test.ecommerce.rest;

import com.me.test.ecommerce.dto.ResponseErrorDto;
import com.me.test.ecommerce.dto.UserDto;
import com.me.test.ecommerce.dto.UserModuleDto;
import com.me.test.ecommerce.entity.UserEntity;
import com.me.test.ecommerce.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Endpoint that manage any API about User Service.
 *
 * @author nobelina.sidabutar
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * API used to find module specified by user id.
     *
     * @param id User ID
     * @return Response body of user module.
     */
    @GetMapping(value = "/v1/find-module-by-id/{id}")
    public UserDto findModuleById(@PathVariable("id") Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User ID not exist!"));
        List<UserModuleDto> userModules = userEntity.getUserModuleEntities().stream()
                .map(userModuleEntity -> new UserModuleDto(userModuleEntity.getModule().getName(),
                        userModuleEntity.getOrder()))
                .sorted(Comparator.comparing(UserModuleDto::getModuleOrder))
                .collect(Collectors.toList());
        return new UserDto(userModules);
    }

    /**
     * API used to handle error.
     *
     * @param ex {@link IllegalArgumentException}
     * @return Response body of error response.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseErrorDto handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseErrorDto(ex.getMessage(), ex.getCause());
    }
}
