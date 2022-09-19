package com.gdschufs.simplejpa2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void postMember(String m_name,String m_email,String m_password)
    {
        memberRepository.post(m_name,m_email,m_password);
    }


}
