package com.gdschufs.simplejpa3.repository;

import org.springframework.stereotype.Repository;
import com.gdschufs.simplejpa3.domain.Order;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
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

    /**
     *
     * @param m_name : 일부만 일치해도 검색 가능
     * @return maxResults = 5
     */
    //search All Order by member name V2
    public List<Order> findOrdersByName(String m_name)
    {
        try {
            return em.createQuery("select o from Order o " +
                            "where o.member.m_name =: m_name ", Order.class)
                    .setParameter("m_name","%"+m_name+"%")
                    .setMaxResults(5)
                    .getResultList();
        }catch(NoResultException nre){
            return null;
        }
    } // 성능을 높이는 법?



    /**
     * JPA Criteria
     */
    public List<Order> findAllByCriteria(String m_name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> o = cq.from(Order.class);
        Join<Object, Object> m = o.join("member", JoinType.INNER);

        List<Predicate> criteria = new ArrayList<>();

        if (StringUtils.hasText(m_name)) {
            Predicate name =
                    cb.like(m.<String>get("name"), "%" +m_name + "%");
            criteria.add(name);
        }
        //주문 상태 검색

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Order> query = em.createQuery(cq).setMaxResults(5);
        return query.getResultList();
    }


}
