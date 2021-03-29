package com.test.board.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    //@JoinColumn(name="board_id")
    private BoardEntity boardId;

    @Column(name="content", nullable = false)
    private String content;

    @Builder
    public CommentEntity(Integer id, BoardEntity boardId, String content) {
        this.id = id;
        this.boardId = boardId;
        this.content = content;
    }
}
