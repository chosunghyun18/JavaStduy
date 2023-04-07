package gnuvil.cms.repository;

import gnuvil.cms.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaRepository extends JpaRepository<Member,Long> {
}
