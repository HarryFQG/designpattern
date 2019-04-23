package com.homolangma.principle.singleresponsibility.v31;

/**
 * 类级别： 注意考虑接口的划分
 */
public class CourseImpl implements ICourse,ICourseManager{

    @Override
    public String getCourseName() {
        return null;
    }

    @Override
    public byte[] getCourseVideo() {
        return new byte[0];
    }

    @Override
    public void studyCourse() {

    }

    @Override
    public void refundCourse() {

    }
}
