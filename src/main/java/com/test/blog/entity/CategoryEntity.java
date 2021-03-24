package com.test.blog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="type", length=45, nullable = false)
    private String type;

    @OneToMany(mappedBy="category")
    private List<BoardEntity> boards = new ArrayList<BoardEntity>();
}
