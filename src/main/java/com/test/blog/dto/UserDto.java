package com.test.blog.dto;

import com.test.blog.entity.UsertypeEntity;
import lombok.*;

@Getter @Setter
@ToString
public class UserDto {

    private Integer userId;
    private UsertypeEntity userType;
    private String name;
    private String phone_number;
    private String email;
    private Integer profile_picture;
}
