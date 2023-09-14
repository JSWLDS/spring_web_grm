package com.example.spring_web.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries
        (
                {
                        @NamedQuery(name = "Member.all", query = "SELECT m FROM Member m " ),
                        @NamedQuery(name = "Member.findByName", query = "SELECT m.name FROM Member m ")
                }
        )
public class Member {

    @Id
    @NotNull
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name="name")
    private String name;
}
