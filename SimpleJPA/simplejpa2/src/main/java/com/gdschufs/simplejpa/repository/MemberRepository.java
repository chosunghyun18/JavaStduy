package com.gdschufs.simplejpa.repository;

import com.gdschufs.simplejpa.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    @Autowired
    private final EntityManager em;

    public void post(String m_name,String m_email,String m_password)
    {
        Member member = new Member();
        member.setM_name(m_name);
        member.setM_password(m_password);
        member.setM_email(m_email);
        em.persist(member);
    }



}
