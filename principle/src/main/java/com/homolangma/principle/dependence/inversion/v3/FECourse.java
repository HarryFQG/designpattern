package com.homolangma.principle.dependence.inversion.v3;

public class FECourse implements ICourse {
    @Override
    public void studyCourse() {
        System.out.println("学生学习FE 课程");
    }
}
