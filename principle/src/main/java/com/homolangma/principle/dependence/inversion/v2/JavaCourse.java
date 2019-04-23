package com.homolangma.principle.dependence.inversion.v2;

public class JavaCourse implements ICourse{
    @Override
    public void studyCourse() {
        System.out.println("学生学习Java 课程");
    }
}
