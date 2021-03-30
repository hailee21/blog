package com.test.board.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    // 연관관계의 주인
    @JsonBackReference
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

    public void setBoard(BoardEntity boardEntity){
        this.boardEntity = boardEntity;

        // 무한루프에 빠지지 않도록 체크
        if(!boardEntity.getComments().contains(this)){
            boardEntity.getComments().add(this);
        }
    }

}
