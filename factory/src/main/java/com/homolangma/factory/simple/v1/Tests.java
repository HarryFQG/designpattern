package com.homolangma.factory.simple.v1;

/**
 * 应用层
 * 简单工厂方式：
 *  缺点：扩展性不好，可以使用反射弥补不足
 *
 *
 */
public class Tests {

    public static void main(String[] args) {
        // 多态的体现
        /*Video video = new JavaVideo();
        video.produce();
        Video pythonVideo = new PythonVideo();
        pythonVideo.produce();*/

        VideoFactory videoFactory = new VideoFactory();
        Video instance = videoFactory.getVideo("java");
        if(instance==null){
            return;
        }
        instance.produce();

    }

}
