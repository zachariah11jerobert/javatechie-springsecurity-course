package com.kkjerome.kkspringsecuritycourse.repository;

import com.kkjerome.kkspringsecuritycourse.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
