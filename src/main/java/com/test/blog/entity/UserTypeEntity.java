package com.test.blog.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserType")
public class UserTypeEntity extends BaseTimeEntity {

    @Id
    @Column(name="id", length=45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="type", length=45)
    private String type;

    @OneToMany(mappedBy="userType")
    private List<UserEntity> users = new ArrayList<UserEntity>();
}
