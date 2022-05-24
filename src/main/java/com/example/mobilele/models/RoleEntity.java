package com.example.mobilele.models;

import com.example.mobilele.models.enums.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private UserRole name;

    public RoleEntity() {
    }

    public Long getId() {
        return id;
    }

    public RoleEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public UserRole getName() {
        return name;
    }

    public RoleEntity setName(UserRole name) {
        this.name = name;
        return this;
    }
}
