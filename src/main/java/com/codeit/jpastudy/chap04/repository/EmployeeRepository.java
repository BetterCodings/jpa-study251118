package com.codeit.jpastudy.chap04.repository;

import com.codeit.jpastudy.chap04.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
