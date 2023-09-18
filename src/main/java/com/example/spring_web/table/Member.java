package com.example.spring_web.table;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull; //
import lombok.Data;

@Entity
@Table(name = "member") // 안써도 나옴
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
