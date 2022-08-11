package com.bakh.springsecuritydemo.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Bakhmai Begaev
 */
@Data
@Entity
@Table(name = "roles_table")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return new SimpleGrantedAuthority(name).toString();
    }
}
