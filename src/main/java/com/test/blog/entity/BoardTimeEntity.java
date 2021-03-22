package com.test.blog.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Boards")
public class BoardTimeEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="userId")
    private UserTimeEntity user;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private CategoryTimeEntity category;

    @Column(name="title", length=100)
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="views")
    private Integer views;
}
