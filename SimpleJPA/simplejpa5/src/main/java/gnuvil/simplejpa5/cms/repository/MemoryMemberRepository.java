package gnuvil.simplejpa5.cms.repository;

import gnuvil.simplejpa5.cms.domain.Member;
import java.util.List;
import java.util.Optional;
import java.util.*;
/*
This Repo implements is for case of no database yet
- >  동시성 문제를 항상 고민하자 , ConcurrentHashMap, AtomicLong
 */
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
