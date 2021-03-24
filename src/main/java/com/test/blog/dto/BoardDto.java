package com.test.blog.dto;

import com.test.blog.entity.BoardEntity;
import com.test.blog.entity.CategoryEntity;
import com.test.blog.entity.UserEntity;
import lombok.*;

@Getter @Setter
@ToString
public class BoardDto {

    private Integer boardId;
    private UserEntity userId;
    private CategoryEntity categoryId;
    private String title;
    private String content;
    private Integer views;
}
