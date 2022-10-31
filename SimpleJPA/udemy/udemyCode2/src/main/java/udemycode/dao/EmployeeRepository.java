package udemycode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import udemycode.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
