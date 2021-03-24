package com.test.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="usertype_id", nullable = false)
    private UsertypeEntity usertypeId;

    @Column(name="name", length=45, nullable = false)
    private String name;

    @Column(name="phone_number", length=11, nullable = false)
    private String phoneNumber;

    @Column(name="email", length=45, nullable = false)
    private String email;

    @Column(name="profile_picture", nullable = false, columnDefinition = "integer default 0")
    private Integer profilePicture;
}
