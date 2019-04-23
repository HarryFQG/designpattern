package com.homolangma.factory.abstractFactory;

public class Tests {

    public static void main(String[] args) {

        CourseFactory courseFactory = new JavaCourseFactory();
        Article article = courseFactory.getArticle();
        Video video = courseFactory.getVideo();
        video.produce();
        article.produce();



    }

}
