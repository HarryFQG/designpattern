package com.homolangma.principle.dependence.inversion.v3;

public class Student implements ICourse{

    private ICourse iCourse;
    public Student(ICourse iCourse){
        this.iCourse=iCourse;
    }
    @Override
    public void studyCourse() {
        iCourse.studyCourse();
    }
}
