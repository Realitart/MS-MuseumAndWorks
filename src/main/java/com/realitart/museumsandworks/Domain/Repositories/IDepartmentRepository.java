package com.realitart.museumsandworks.Domain.Repositories;

import com.realitart.museumsandworks.Domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {
}
