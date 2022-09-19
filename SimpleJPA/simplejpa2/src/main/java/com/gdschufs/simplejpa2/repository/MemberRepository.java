package com.gdschufs.simplejpa2.repository;

import com.gdschufs.simplejpa2.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    @Autowired
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public void delete(Long id)
    {
        Member member = em.find(Member.class , id);
        em.remove(member);
    }

    /**
     * @id   //  pk of Membertable
     * @return  // instance of Member
     **/
    public Member findOne(Long id) {
        return em.find(Member.class,id);
    }

    public List<Member> findALL() {
        return em.createQuery("select m from Member m",Member.class).getResultList();
    }


    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.m_name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
