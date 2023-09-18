package com.example.spring_web.repository;

import com.example.spring_web.table.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;


@Transactional
@Service
public class TableRepository_test {


    @PersistenceContext
    EntityManager em;

    public List<Member> findAll() {
        TypedQuery<Member> nameQuery = em.createNamedQuery("Member.findByName", Member.class);
        List<Member> nameList = nameQuery.getResultList();
        return nameList;
    }

}
