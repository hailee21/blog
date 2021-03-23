package com.test.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="userTypeId")
    private UserTypeEntity userType;

    @Column(name="name", length=45)
    private String name;

    @Column(name="phoneNumber", length=11)
    private String phoneNumber;

    @Column(name="email", length=45)
    private String email;

    @Column(name="profilePicture")
    private Integer profilePicture;
}
