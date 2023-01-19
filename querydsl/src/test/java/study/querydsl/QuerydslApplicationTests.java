package study.querydsl;

import static org.assertj.core.api.Assertions.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.domain.helloworld.model.Hello;
import study.querydsl.domain.helloworld.model.QHello;

@Transactional
@SpringBootTest
class QuerydslApplicationTests {

	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {
	}
	@Test
	void contextHelloLoads() {
		Hello hello = new Hello();
		em.persist(hello);

		JPAQueryFactory query = new JPAQueryFactory(em);

		QHello qHello = new QHello("hi"); // no space in variable

		Hello result = query
				.selectFrom(qHello)
				.fetchOne();
		assertThat(result).isEqualTo(hello);
		// test lombok
		assertThat(result.getId()).isEqualTo(hello.getId());

	}
}
