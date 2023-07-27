package com.green.secondproject.timetable.model;

import lombok.Data;

import java.util.List;


@Data
public class TimeTableContainerVo {
    private String schoolNm;
    private String grade; // 강동고등학교 1학년 1반 1학기 ()
    private String classNm;
    private String semester;
    private List<TimeTableVo> list;

    public TimeTableContainerVo(String schoolNm, String semester, String grade, String classNm, List<TimeTableVo> list){
        this.schoolNm = schoolNm;
        this.grade=grade;
        this.semester = semester;
        this.classNm=classNm;
        this.list = list;
    }
}