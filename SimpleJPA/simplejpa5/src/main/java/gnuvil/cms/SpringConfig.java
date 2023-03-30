package gnuvil.cms;

import gnuvil.cms.repository.MemberRepository;
import gnuvil.cms.repository.MemoryMemberRepository;
import gnuvil.cms.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
