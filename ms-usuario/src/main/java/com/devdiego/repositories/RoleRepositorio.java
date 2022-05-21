package com.devdiego.repositories;

import com.devdiego.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositorio extends JpaRepository<Role, Long> {
}
