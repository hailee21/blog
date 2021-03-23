package com.test.blog.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Boards")
public class BoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private CategoryEntity category;

    @Column(name="title", length=100)
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="views")
    private Integer views;
}
