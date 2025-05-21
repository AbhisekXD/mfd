package com.cyfrifpro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyfrifpro.model.Role;
import com.cyfrifpro.model.enums.RoleEnum;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
	// 11-12
	Optional<Role> findByRoleName(RoleEnum roleToAssign);

	Optional<Role> findByRoleId(Long roleId);
}