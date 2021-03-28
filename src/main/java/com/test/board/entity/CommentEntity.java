package com.test.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter @NoArgsConstructor
@Entity
@Table(name="comments")
public class CommentEntity extends BaseTimeEntity {
    @Id
    @Column(name="comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="board_id")
    private BoardEntity boardEntity;

    @Column(name="content", nullable = false)
    private String content;

    @Builder
    public CommentEntity(Integer id, BoardEntity boardEntity, String content) {
        this.id = id;
        this.boardEntity = boardEntity;
        this.content = content;
    }
}
