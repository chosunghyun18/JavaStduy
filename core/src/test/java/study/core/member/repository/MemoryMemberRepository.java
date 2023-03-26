package study.core.member.repository;

import java.util.concurrent.ConcurrentHashMap;
import study.core.member.model.Member;
import study.core.member.repository.MemberRepository;

public class MemoryMemberRepository implements MemberRepository {

    private static ConcurrentHashMap<Long, Member> store = new ConcurrentHashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
