package hellospring.hellospring;


import hellospring.hellospring.repsitory.JdbcMemberRepository;
import hellospring.hellospring.repsitory.MemberRepository;
import hellospring.hellospring.repsitory.MemoryMemberRepository;
import hellospring.hellospring.서비.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringCofig {


    private final MemberRepository memberRepository;

    @Autowired
    public SpringCofig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    /*
    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);

    }*/
}
