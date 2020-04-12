package com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entities.ERole;
import com.Entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);

}
