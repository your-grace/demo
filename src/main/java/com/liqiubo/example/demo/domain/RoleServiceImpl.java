package com.liqiubo.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<TSRole> getAllRoles() {

        return roleRepository.findAll();
    }
}
