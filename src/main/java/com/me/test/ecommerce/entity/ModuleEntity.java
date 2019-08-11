package com.me.test.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

/**
 * The entity to provide the `Module` data and represent the columns in the database.
 *
 * @author nobelina.sidabutar
 */
@Data
@Entity
@Table(name = "module")
public class ModuleEntity implements Serializable {

    @Id
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    private Set<UserModuleEntity> userModuleEntities;
}
