package com.green.secondproject.mypage.model;

import lombok.Data;

@Data
public class UpdTeacherInfoDto {
    private Long userId;
    private String nm;
    private String phone;
    private String address;
}