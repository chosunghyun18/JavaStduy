package com.gdschufs.simplejpa3.repository;

import org.springframework.stereotype.Repository;
import com.gdschufs.simplejpa3.domain.Order;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;


@Repository
public class OrderRepository
{

    private final EntityManager em;
    public OrderRepository(EntityManager em) {
        this.em = em;
    }


    public void save(Order order)
    {
        em.persist(order);
    }

    /**
     *
     * @param id : order pk
     * @return instance of Order
     */
    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }



    //search All Order by member name
    public List<Order> findOrderByName(String m_name)
    {
        try {
            return em.createQuery("select o from Order o " +
                            "where o.member.m_name =: m_name ", Order.class)
                    .setParameter("m_name",m_name)
                    .getResultList();
        }catch(NoResultException nre){
            return null;
        }
    }


}
