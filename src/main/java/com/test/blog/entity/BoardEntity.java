package com.test.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "boards")
public class BoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private CategoryEntity categoryId;

    @Column(name="title", length=100, nullable = false)
    private String title;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="views", nullable = false, columnDefinition = "integer default 0")
    private Integer views;
}
