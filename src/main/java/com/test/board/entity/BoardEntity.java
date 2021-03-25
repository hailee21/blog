package com.test.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter @NoArgsConstructor
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

    @Column(name="views", nullable = false, columnDefinition = "integer default 0")
    private Integer views;

    @Builder
    public BoardEntity(Integer id, String title, String content, Integer views) {
        System.out.println("--Entity Builder--");
        //Assert.hasText(bankName, "bankName must not be empty");
        //Assert.hasText(accountNumber, "accountNumber must not be empty");
        //Assert.hasText(accountHolder, "accountHolder must not be empty");

        this.id = id;
        this.title = title;
        this.content = content;
        this.views = views;
    }
}
