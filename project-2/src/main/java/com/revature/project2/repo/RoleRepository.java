package com.revature.project2.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.project2.model.ERole;
import com.revature.project2.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(ERole name);
}
