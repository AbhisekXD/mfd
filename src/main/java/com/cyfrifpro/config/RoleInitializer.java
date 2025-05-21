package com.cyfrifpro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.cyfrifpro.model.Role;
import com.cyfrifpro.model.enums.RoleEnum;
import com.cyfrifpro.repositories.RoleRepo;
import jakarta.transaction.Transactional;
import java.util.Optional;

@Component
public class RoleInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        createRoleIfNotExists(101L, RoleEnum.MASTER_ADMIN, null);
        createRoleIfNotExists(102L, RoleEnum.CONTROL_PANEL, 101L);
        createRoleIfNotExists(103L, RoleEnum.DISTRIBUTOR, 102L);
        createRoleIfNotExists(104L, RoleEnum.RELATIONSHIP_MANAGER, 103L);
        createRoleIfNotExists(105L, RoleEnum.CLIENT, 104L);

        System.out.println("Roles initialized successfully.");
    }

    private void createRoleIfNotExists(Long roleId, RoleEnum roleName, Long parentRoleId) {
        Optional<Role> existingRole = roleRepo.findById(roleId);
        if (existingRole.isEmpty()) {
            Role role = new Role();
            role.setRoleId(roleId); // Manually setting roleId
            role.setRoleName(roleName);

            if (parentRoleId != null) {
                roleRepo.findById(parentRoleId).ifPresent(role::setParent);
            }

            roleRepo.save(role);
            System.out.println("Inserted role: " + roleName + " with ID: " + roleId);
        }
    }
}
