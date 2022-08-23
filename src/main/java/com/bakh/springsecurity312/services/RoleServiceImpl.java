package com.bakh.springsecurity312.services;

import com.bakh.springsecurity312.models.Role;
import com.bakh.springsecurity312.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bakhmai Begaev
 */
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;


    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
