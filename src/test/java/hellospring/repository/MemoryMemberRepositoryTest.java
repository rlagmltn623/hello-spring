package hellospring.repository;


import hellospring.repsitory.MemoryMemberRepository;
import hellospring.도메인.Member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    //데이터 리셋
    @AfterEach
    public void afterEach(){
        repository.clearStore(); //이건 필수 공용 데이터를 싹  지워줘야함
    }
    @Test
    public  void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();//꺼낼때
        //System.out.println("result = " + (result == member));
        assertThat(member).isEqualTo(result);


    }
    @Test
    public void findByname(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result  =repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);


    }
}
