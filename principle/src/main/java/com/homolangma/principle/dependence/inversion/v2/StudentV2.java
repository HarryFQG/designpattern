package com.homolangma.principle.dependence.inversion.v2;

/**
 * 面向接口实现
 */
public class StudentV2 {

    public void studyImoocCourse(ICourse iCourse) {
        iCourse.studyCourse();
    }


}
