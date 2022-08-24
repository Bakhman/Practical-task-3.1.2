package com.bakh.springsecurity312.service;

import com.bakh.springsecurity312.model.Role;
import com.bakh.springsecurity312.repository.RoleRepository;
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
