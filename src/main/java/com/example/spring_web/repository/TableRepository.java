package com.example.spring_web.repository;

import com.example.spring_web.table.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Transactional
@Repository
public class TableRepository {


    @PersistenceContext
    EntityManager em;

    public List<Member> findAll() {
        TypedQuery<Member> nameQuery = em.createNamedQuery("Member.findByName", Member.class);
        List<Member> nameList = nameQuery.getResultList();
        return nameList;
    }

}
