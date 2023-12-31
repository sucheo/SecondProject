package com.green.secondproject.teacher;

import com.green.secondproject.student.model.*;
import com.green.secondproject.teacher.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    List<SelSignedStudentVo> selSignedStudent(SelSignedStudentDto dto);
    List<SelUnsignedStudentVo> selUnsignedStudent(SelUnsignedStudentDto dto);
    List<SelAcaResultVo> selAcaResult(SelAcaResultDto dto);
    List<SelMockResultVo> selMockResult(SelMockResultDto dto);
    int acceptStudent(AcceptStudentDto dto);
//    int rejectStudent(AcceptStudentDto dto);
    int cancelAcceptStd(AcceptStudentDto dto);
    int updMockResult(UpdMockResultDto dto);
    int updAcaResult(UpdAcaResultDto dto);
    int delMockResult(DelResultDto dto);
    int delAcaResult(DelResultDto dto);
    int classStudent(ClassStudentDto dto);
    int aprStudent(ClassStudentDto dto);

    List<StudentMockSumResultWithIdVo> selMockTestResultByDates(StudentSummarySubjectDto dto);
    List<StudentAcaResultWithIdVo> selAcaTestResultByDatesAndPeriodAndStudent(StudentAcaResultsParam param);
    List<TeacherGraphVo> teacherAcaGraph(Long classId,Long categoryId);
    double getNumberOfStudentByCate(TeacherGraphDto dto);
    String getLatestTest();
}
