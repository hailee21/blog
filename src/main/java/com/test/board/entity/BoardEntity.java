package com.test.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter @NoArgsConstructor
@Setter
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "boards")
public class BoardEntity extends BaseTimeEntity {

    @Id
    @Column(name="board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title", length=100, nullable = false)
    private String title;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="views", nullable = true, columnDefinition = "integer default 0")
    private Integer views;

    @Builder
    public BoardEntity(Integer id, String title, String content, Integer views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.views = views;
    }
}
