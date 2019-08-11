package com.me.test.ecommerce.repository;

import com.me.test.ecommerce.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository of {@link UserEntity}
 *
 * @author nobelina.sidabutar
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
