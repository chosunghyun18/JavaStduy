package jpabook.jpashop.repository;


import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em ;

    // command 와 쿼리를 분리 해라. 저장 하는것은 return 값이 보통 없다. 논리적으로
    public Long save(Member member)
    {
        em.persist(member);
        return member.getId();
    }
    public Member find(Long id){
        return em.find(Member.class,id);
    }



}
