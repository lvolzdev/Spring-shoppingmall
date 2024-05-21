package com.example.demo.member;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {
    private Map<String, Member> memberTable
            = new HashMap<>();

//    @Autowired
//    DataSource dataSource;

    @Autowired
    EntityManager entityManager;

//    public void makeConnection() {
//        DataSourceUtils.getConnection(dataSource);
//    }

    @Transactional
    public String save(Member member) {
        entityManager.persist(member);

        Member SavedMember = entityManager.find(Member.class, member.getId());
        return SavedMember.getUserId();
    }

    public Member findById(String userId) {
        return memberTable.get(userId);
    }
}