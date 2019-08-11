package com.me.test.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The entity to provide the `UserModule` data and represent the columns in the database.
 *
 * @author nobelina.sidabutar
 */
@Data
@Entity
@Table(name = "user_module")
public class UserModuleEntity implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private UserEntity user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private ModuleEntity module;

    @Column(name = "order")
    private int order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModuleEntity)) return false;
        UserModuleEntity that = (UserModuleEntity) o;
        return Objects.equals(user.getId(), that.user.getId()) &&
                Objects.equals(module.getId(), that.module.getId()) &&
                Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getId(), module.getId(), order);
    }
}
