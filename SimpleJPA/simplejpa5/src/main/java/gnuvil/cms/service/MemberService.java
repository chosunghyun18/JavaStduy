package gnuvil.cms.service;

import gnuvil.cms.domain.Member;
import gnuvil.cms.repository.MemberRepository;
import gnuvil.cms.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository ;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    public void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName()).ifPresent( m-> {
            throw  new IllegalStateException("already exist");
        });
    }
    public List<Member> findMembers() {
        return  memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
