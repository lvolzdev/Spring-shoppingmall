package com.example.demo.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    @Transactional
    public String join(Member member) {
        memberRepository.save(member);

        String userId = memberRepository
                .findByUserId(member.getUserId())
                .getUserId();

        return userId;
    }

    public boolean checkDuplicateId(String userId) {
        Member existMember = memberRepository.findByUserId(userId);

        if (existMember == null)
            return false;
        else
            return true;
    }
}