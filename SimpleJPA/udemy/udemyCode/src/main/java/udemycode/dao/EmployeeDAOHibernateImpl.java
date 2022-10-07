package udemycode.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import udemycode.domain.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{


    //define field of entitManagere
    private EntityManager em;

    //set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityM){
        em = theEntityM;
    }

    @Override // no transactional to handle in service
    public List<Employee> findAll() {

        //get current hibernate session
        Session currentSession = em.unwrap(Session.class);

        //Create  Query  영상 532
        //Query<Employee> theQuery = currentSession.createQuery("from Employee ",Employee.class);

        Query<Employee> theQuery = currentSession.createQuery("select e from Employee e ",Employee.class);

        // get result list
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get the current hibernate session
        Session currentSession = em.unwrap(Session.class);
        // get the emploee
        Employee theEmployee = currentSession.get(Employee.class,theId);

        // return the employee
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Session currentSession = em.unwrap(Session.class);
        // save employee
        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = em.unwrap(Session.class);
        // save employee
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId",theId);
        theQuery.executeUpdate();

    }
}
