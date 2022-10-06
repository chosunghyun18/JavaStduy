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

    @Override
    @Transactional
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
}
