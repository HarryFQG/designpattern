package com.homolangma.build.v1;

public class Test1 {

    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);
        Course course = coach.makeCourse("java设计模式", "Java PPT", "java 视频", "java 文章", "java 问答");
        System.out.println(course);

    }

}
