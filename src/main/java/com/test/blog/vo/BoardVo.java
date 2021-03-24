package com.test.blog.vo;

import com.test.blog.entity.BoardEntity;
import com.test.blog.entity.CategoryEntity;
import com.test.blog.entity.UserEntity;
import lombok.*;

@Getter @Setter
@ToString
public class BoardVo {

    private Integer boardId;
    private UserEntity userId;
    private CategoryEntity categoryId;
    private String title;
    private String content;
    private Integer views;

    @Builder
    public BoardVo(Integer boardId, UserEntity userId, CategoryEntity categoryId, String title, String content, Integer views) {
        this.boardId = boardId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.views = views;
    }
}
