package com.homolangma.principle.dependence.inversion.v2;

public class PythonCourse implements ICourse{
    @Override
    public void studyCourse() {
        System.out.println("学生学习Python 课程");
    }
}
