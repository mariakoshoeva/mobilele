package com.example.mobilele.models.binding;

import com.example.mobilele.models.enums.UserRole;
import com.example.mobilele.models.validation.UniqueUserName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserRegisterBindingModel {
    @NotEmpty
    @Length(min = 2,max = 20)
    private String firstName;

    @NotEmpty
    @Length(min = 2,max = 20)
    private String lastName;

    @NotEmpty
    @Length(min = 2,max = 20)
    @UniqueUserName(message = "User with such username already exist!")
    private String username;

    @NotEmpty
    @Length(min = 2,max = 20)
    private String password;

    @NotNull
    private UserRole role;

    public UserRole getRole() {
        return role;
    }

    public UserRegisterBindingModel setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
