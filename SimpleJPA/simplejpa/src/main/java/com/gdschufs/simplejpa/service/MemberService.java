package com.gdschufs.simplejpa.service;

import com.gdschufs.simplejpa.domain.Member;
import com.gdschufs.simplejpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * @param m_name
     * @param m_email
     * @param m_password
     * @return void
     */
    @Transactional
    public void postMember(String m_name,String m_email,String m_password)
    {
        memberRepository.post(m_name,m_email,m_password);
    }
    @Transactional
    public void deleteMember(Long id)
    {
        memberRepository.delete(id);
    }

    /**
     * @param id
     * @return Member instance
     */
    @Transactional(readOnly = true)   // https://willseungh0.tistory.com/75
    public Member findOneByid(Long id)
    {
        return memberRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<Member> findALL()
    {
        return memberRepository.findALL();
    }
}
