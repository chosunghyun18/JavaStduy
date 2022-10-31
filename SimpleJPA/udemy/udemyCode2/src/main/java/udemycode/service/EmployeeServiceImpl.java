package udemycode.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import udemycode.dao.EmployeeDAO;
import udemycode.dao.EmployeeRepository;
import udemycode.domain.Employee;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    // remove @transactional cause JPARepository provide it
    @Override
    public Employee findById(int theId) {
        // Optional for null check
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        }else {throw new RuntimeException("Did not find employee id"+theId);}

        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
