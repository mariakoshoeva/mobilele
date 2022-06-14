package com.example.mobilele.user;

import com.example.mobilele.models.entities.RoleEntity;
import com.example.mobilele.models.enums.UserRole;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private boolean isLoggedIn;
    private String username;
    private String firstName;
    private String lastName;
    private Long id;
    private RoleEntity role;

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CurrentUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CurrentUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isAdmin(){
        if(role == null){
            return false;
        }
        return role.getName().equals(UserRole.ADMIN);
    }

    public RoleEntity getRole() {
        return role;
    }

    public CurrentUser setRole(RoleEntity role) {
        this.role = role;
        return this;
    }
}
