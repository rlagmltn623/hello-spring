package hellospring.hellospring.서비;

import hellospring.hellospring.repsitory.MemberRepository;
import hellospring.hellospring.도메인.Member;


import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memoryMemberRepository;


    public MemberService(MemberRepository memoryMemberRepository) {
        this.memoryMemberRepository = memoryMemberRepository;
    }




    /**
     *
     * 회원가입입     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); //중복 회원 검증
        memoryMemberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memoryMemberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw  new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     *
     * 전체회원 조회
     */
    public List<Member> findMembers(){
        return memoryMemberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memoryMemberRepository.findById(memberId);
    }
}
