package com.green.secondproject.teacher.subject;

import com.green.secondproject.teacher.subject.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ToString
@RequestMapping("/api/teacher/subject")
@Tag(name = "과목")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectSerivce serivce;


    @GetMapping("/category")
    @Operation(summary = "선생님 과목계열 리스트",
            description = "nm - 학생이름"+
                    "<br>categoryid - category 테이블에 카테고리pk값")

    List<SubjectVo> subcate(){
        return serivce.subcate();
    }

    @GetMapping()
    @Operation(summary = "선생님 세부과목 리스트",
            description = "subjectid - subject 테이블에 과목 PK값" +
                    "<br>nm - 학생이름"+
                    "<br>categoryid - category 테이블에 카테고리pk값")
    List<SubjectDetailVo> subject(){
        return serivce.subject();
    }

    @PostMapping
    @Operation(summary = "과목 등록",
    description = "입력값 : userid - 유저고유번호<br>" +
    "subjectid - 과목 번호<br>")
    int instcsbj(@RequestBody SubjectInsDto dto){
        return serivce.instcsbj(dto);
    }

    @GetMapping("/category/big")
    @Operation(summary = "등록후 과목계열 리스트"
    ,description = "입력값 : userid - 유저 pk값<br> "+
            "출력값 : subjectid - subject 테이블에 과목 PK값" +
            "<br>nm - 학생이름"+
            "<br>userid - 학생 pk값")
    List<SubjectDetailVo2> tcslist(@RequestParam Long userid)
    {
        SubjectDetailDto dto = new SubjectDetailDto();
        dto.setUserid(userid);
        return serivce.tcslist(dto);
    }
    @GetMapping("/category/small")
    @Operation(summary = "등록후 세부과목 리스트"
            ,description = "출력값 : userid - 유저 pk값<br> "+
            "categoryid - category 테이블에 세부과목 PK값" +
            "<br>nm - 학생이름"+
            "<br>입력값 : " +"<br>userid - 학생 pk값")
    List<SubjectVo2> smalllist(@RequestParam Long userid){
        SubjectDto dto = new SubjectDto();
        dto.setUserid(userid);
        return serivce.smalllist(dto);
    }
    @GetMapping("/classnum")
    @Operation(summary = "반석차 반전체인원") //근데이거 calss id 19번인가 넘어가야 2번째학교 나옴 흠; 애매 차라리 컬럼을 늘리는게 이쁘긴할듯
    int classnum(@RequestParam Long classid,@RequestParam Long schoolid){
        StudentClassDto dto = new StudentClassDto();
        dto.setClassid(classid);
        dto.setSchoolid(schoolid);
        return serivce.classnum(dto);
    }

    @GetMapping("/schoolsnum")
    @Operation(summary = "학교 학년전체인원")
    int schoolnum(@RequestParam char grade,@RequestParam Long schoolid){
        StudentSchoolDto dto = new StudentSchoolDto();
        dto.setSchoolid(schoolid);
        dto.setGrade(grade);
        return serivce.schoolnum(dto);
    }
    @PostMapping
    @Operation(summary = "학생별 내신성적등록")
    int acasubject(@RequestBody AcaSubjectDto dto){
        return serivce.acasubject(dto);
    }

}
