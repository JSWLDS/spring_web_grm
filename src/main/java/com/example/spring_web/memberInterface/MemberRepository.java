package com.example.spring_web.memberInterface;

import com.example.spring_web.table.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MemberRepository extends CrudRepository<Member, Long> {

}
