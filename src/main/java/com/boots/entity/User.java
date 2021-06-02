package com.boots.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=3, max = 16, message = "Please use from 3 to 16 symbols")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Please use only latin symbols")
    @Column(unique = true)
    private String username;

//    @Pattern(regexp = "^(?=[a-zA-Z0-9]{3,16}$)(?=.*?[A-Za-z])(?=.*?[0-9]).*$",
//            message = "Please use only latin symbols and numbers, min 1 number, min 1 symbol, \n" +
//                    "from 3 to 16 symbols")
    private String password;

    @Transient
    private String passwordConfirm;

    @Size(min=1, max = 16, message = "Please use from 1 to 16 symbols")
//    @Pattern(regexp = "^[a-zA-Z]+$", message = "Please use only latin symbols")
    private String firstName;

    @Size(min=1, max = 16, message = "Please use from 1 to 16 symbols")
//    @Pattern(regexp = "^[a-zA-Z]+$", message = "Please use only latin symbols")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
