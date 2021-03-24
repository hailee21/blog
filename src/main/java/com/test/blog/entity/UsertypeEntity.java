package com.test.blog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usertype")
public class UsertypeEntity extends BaseTimeEntity {

    @Id
    @Column(name="id", length=45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="type", length=45, nullable = false)
    private String type;

    @OneToMany(mappedBy="usertype")
    private List<UserEntity> users = new ArrayList<UserEntity>();
}
