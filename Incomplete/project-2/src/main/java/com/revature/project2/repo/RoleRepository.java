package com.revature.project2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.project2.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
