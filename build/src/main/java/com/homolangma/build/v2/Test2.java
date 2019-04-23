package com.homolangma.build.v2;

public class Test2 {

    public static void main(String[] args) {


        Course course = new Course.CourseBuilder().buildCourseArticle("Java 课程文章").builderCourseName("Java 课程").buildCourseQA("Java 课程问答").build();
        System.out.println(course);
    }


}
