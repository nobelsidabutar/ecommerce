package com.me.test.ecommerce.repository;

import com.me.test.ecommerce.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository of {@link ModuleEntity}
 *
 * @author nobelina.sidabutar
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {
}
