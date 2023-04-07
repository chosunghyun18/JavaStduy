package gnuvil.cms.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import gnuvil.cms.domain.Member;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class DataJpaRepositoryTest {

    @Autowired DataJpaRepository dataJpaRepository;

    @Test
    void join() throws Exception{
        Member member = new Member();
        member.setName("hello");

        Member savedMember = dataJpaRepository.save(member);
        Member findMember = dataJpaRepository.findById(savedMember.getId()).orElseThrow(NullPointerException::new);

        assertThat(findMember).isEqualTo(savedMember);
        assertThat(findMember).isEqualTo(member);
    }
}