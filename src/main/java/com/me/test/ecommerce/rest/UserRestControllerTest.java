package com.me.test.ecommerce.rest;

import com.me.test.ecommerce.entity.ModuleEntity;
import com.me.test.ecommerce.entity.UserEntity;
import com.me.test.ecommerce.entity.UserModuleEntity;
import com.me.test.ecommerce.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Class that provide various test for {@link UserRestController}.
 *
 * @author nobelina.sidabutar
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserRestController.class)
public class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testFindModuleById_thenReturnOK() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setEmail("user1@mail.com");
        userEntity.setName("UserA");

        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setId(1L);
        moduleEntity.setName("Promo");

        UserModuleEntity userModuleEntity = new UserModuleEntity();
        userModuleEntity.setModule(moduleEntity);
        userModuleEntity.setOrder(1);
        userModuleEntity.setUser(userEntity);
        userEntity.setUserModuleEntities(new HashSet<>(Collections.singletonList(userModuleEntity)));

        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        mockMvc.perform(get("/user/v1/find-module-by-id/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.modules", hasSize(1)))
                .andExpect(jsonPath("$.modules[0].moduleName", is("Promo")))
                .andExpect(jsonPath("$.modules[0].moduleOrder", is(1)));
    }

    @Test
    public void testFindModuleByIdWithOrder_thenReturnOK() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setEmail("user1@mail.com");
        userEntity.setName("UserA");

        ModuleEntity moduleEntity1 = new ModuleEntity();
        moduleEntity1.setId(1L);
        moduleEntity1.setName("Promo");

        ModuleEntity moduleEntity2 = new ModuleEntity();
        moduleEntity2.setId(1L);
        moduleEntity2.setName("News");

        UserModuleEntity userModuleEntity1 = new UserModuleEntity();
        userModuleEntity1.setModule(moduleEntity1);
        userModuleEntity1.setOrder(2);
        userModuleEntity1.setUser(userEntity);

        UserModuleEntity userModuleEntity2 = new UserModuleEntity();
        userModuleEntity2.setModule(moduleEntity2);
        userModuleEntity2.setOrder(1);
        userModuleEntity2.setUser(userEntity);
        userEntity.setUserModuleEntities(new HashSet<>(Arrays.asList(userModuleEntity1, userModuleEntity2)));

        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        mockMvc.perform(get("/user/v1/find-module-by-id/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.modules", hasSize(2)))
                .andExpect(jsonPath("$.modules[0].moduleName", is("News")))
                .andExpect(jsonPath("$.modules[0].moduleOrder", is(1)))
                .andExpect(jsonPath("$.modules[1].moduleName", is("Promo")))
                .andExpect(jsonPath("$.modules[1].moduleOrder", is(2)));
    }

    @Test
    public void testFindModuleById_whenIdNotExist_thenReturnOK() throws Exception {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/user/v1/find-module-by-id/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error", is("User ID not exist!")))
                .andExpect(jsonPath("$.exception", is(nullValue())));
    }
}
