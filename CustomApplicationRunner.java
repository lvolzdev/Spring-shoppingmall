package com.example.demo;

import com.example.demo.member.Member;
import com.example.demo.member.MemberJPARepository;
import com.example.demo.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomApplicationRunner implements ApplicationRunner {

    @Autowired
    MemberJPARepository memberJPARepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("동시에 실행됨");

        Optional<Member> resultMember =
                memberJPARepository.findByUserId("sieun");
        if(resultMember.isEmpty())
            System.out.println("Empty !!!");
        else
            System.out.println(resultMember.get().getUserId());
    }
}
