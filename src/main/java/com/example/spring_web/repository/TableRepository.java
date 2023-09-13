package com.example.spring_web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TableRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<String> getAllName(){
        List<String> nameList = new ArrayList<>();
        nameList.addAll(jdbcTemplate.queryForList("select name from member", String.class));

        return nameList;
    }

}
