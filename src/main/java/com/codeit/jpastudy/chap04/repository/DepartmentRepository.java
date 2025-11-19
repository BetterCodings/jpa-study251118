package com.codeit.jpastudy.chap04.repository;

import com.codeit.jpastudy.chap04.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
