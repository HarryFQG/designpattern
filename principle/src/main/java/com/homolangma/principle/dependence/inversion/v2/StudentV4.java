package com.homolangma.principle.dependence.inversion.v2;

public class StudentV4 {

    private ICourse iCourse;

    public ICourse getiCourse() {
        return iCourse;
    }

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }


    public void studyImoocCourse() {
        iCourse.studyCourse();
    }



}
