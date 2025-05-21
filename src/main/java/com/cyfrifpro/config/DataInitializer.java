package com.cyfrifpro.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cyfrifpro.model.Role;
import com.cyfrifpro.model.enums.RoleEnum;
import com.cyfrifpro.repositories.RoleRepo;

//11-12
@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepo roleRepo;

    public DataInitializer(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        initializeRoles();
    }

    private void initializeRoles() {
        // Check if roles already exist
        if (roleRepo.count() == 0) {
            // Add roles
            for (RoleEnum roleEnum : RoleEnum.values()) {
                Role role = new Role();
                role.setRoleName(roleEnum);
                roleRepo.save(role);
            }
            System.out.println("Roles initialized");
        } else {
            System.out.println("Roles already initialized");
        }
    }
}

