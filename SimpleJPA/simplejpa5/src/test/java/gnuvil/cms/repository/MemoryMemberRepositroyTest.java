package gnuvil.cms.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import gnuvil.cms.domain.Member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositroyTest {
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 하나_저장하기() {
        // given   : data prep
        Member member = new Member();
        member.setName("spring");
        //when : case of action
        memberRepository.save(member);
        //then  :
        Member result  = memberRepository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);

    }
    @Test
    void 다중_저장하기_확인() {
        // given   : data prep
        Member member = new Member();
        String givenName = "spring";
        member.setName(givenName);
        //when : case of action
        memberRepository.save(member);
        //then  :
//        Member result  = memberRepository.findById(member.getId()).get();
        Member result  = memberRepository.findById(member.getId()).orElseThrow(NullPointerException::new);

        assertAll(
                () ->  assertNotNull(result),
                () ->  assertTrue(result.getId() >0 ,() -> "id 는 0보다 커야한다."));
    }

    @Test
    void findById() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("spring1").orElseThrow(NullPointerException::new);

        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findByName() {
    }

    @Test
    void findAll() {
    }

    @Test
    void clearStore() {
    }
}