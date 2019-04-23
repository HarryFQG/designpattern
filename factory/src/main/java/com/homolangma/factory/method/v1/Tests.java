package com.homolangma.factory.method.v1;

/**
 * 工厂方法
 */
public class Tests {

    public static void main(String[] args) {
        VideoFactory videoFactory = new JavaVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();


        VideoFactory pythonVideoFactory = new PythonVideoFactory();
        Video video1 = pythonVideoFactory.getVideo();
        video1.produce();


    }

}
