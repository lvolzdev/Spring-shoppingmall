package com.example.demo.member;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemberRepository {
    private Map<String, Member> memberTable
            = new HashMap<>();

    @Autowired
    EntityManager entityManager;

    public void save(Member member) {
        entityManager.persist(member);
    }

    public Member findByUserId(String userId) {
        String jpql = "SELECT m FROM Member m WHERE m.userId = :userId";

        Member foundMember = entityManager.createQuery(jpql, Member.class)
                                        .setParameter("userId", userId)
                                        .getSingleResult();
        if (foundMember == null)
            return null;
        else
            return foundMember;
    }

    public Member findById(int id) {
        return entityManager.find(Member.class, id);
    }
}