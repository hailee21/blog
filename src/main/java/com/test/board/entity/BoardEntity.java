package com.test.board.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @NoArgsConstructor
@Setter
@NamedEntityGraph(name="BoardEntity.comments",
    attributeNodes = @NamedAttributeNode("comments"))
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "boards")
public class BoardEntity extends BaseTimeEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title", length=100, nullable = false)
    private String title;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="views", columnDefinition = "integer default 0")
    private Integer views;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "boardEntity", cascade = CascadeType.ALL)
    private List<CommentEntity> comments = new ArrayList<>();

    @Builder
    public BoardEntity(Integer id, String title, String content, Integer views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.views = views;
    }
}
