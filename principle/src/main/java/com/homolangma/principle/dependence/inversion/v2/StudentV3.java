package com.homolangma.principle.dependence.inversion.v2;

/**
 * V3 构造注入
 */
public class StudentV3 {

    private ICourse iCourse;

    public StudentV3(ICourse iCourse){
        this.iCourse=iCourse;
    }

    public void studyImoocCourse() {
        iCourse.studyCourse();
    }

}
