package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

  private static Map<Long, Member> store = new HashMap<>(); // static 사용
  private static long sequence = 0L; // static 사용
  private static final MemberRepository instance = new MemberRepository(); // 싱글톤 패턴을 적용: 스프링 없이 순수 서블릿 만으로 구현하는 것이 목적이기에
  public static MemberRepository getInstance() {
    return instance;
  }
  private MemberRepository() {
  }
  public Member save(Member member) {
    member.setId(++sequence);
    store.put(member.getId(), member);
    return member;
  }
  public Member findById(Long id) {
    return store.get(id);
  }
  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }
  public void clearStore() {
    store.clear();
  }
}