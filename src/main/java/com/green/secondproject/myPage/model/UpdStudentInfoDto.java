package com.green.secondproject.myPage.model;

import lombok.Data;

@Data
public class UpdStudentInfoDto {
    private Long userId;
    private String nm;
    private String phone;
    private String address;
    private String pic;
}