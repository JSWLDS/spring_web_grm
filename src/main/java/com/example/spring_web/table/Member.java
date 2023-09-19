package com.example.spring_web.table;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull; //
import lombok.Data;

@Entity
@Table(name = "member") // 엔티티와 매핑할 테이블을 지정, 생략 시 매핑한 엔티티 이름을 테이블 이름으로 사용
@Data
//@NamedQueries
//        (
//                {
//                        @NamedQuery(name = "Member.all", query = "SELECT m FROM Member m " ),
//                        @NamedQuery(name = "Member.findByName", query = "SELECT m.name FROM Member m ")
//                }
//        )
public class Member {

    @Id
    @NotNull
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name="name")
    private String name;
}
