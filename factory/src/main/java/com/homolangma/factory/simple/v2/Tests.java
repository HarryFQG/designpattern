package com.homolangma.factory.simple.v2;

import com.homolangma.factory.simple.v1.JavaVideo;
import com.homolangma.factory.simple.v1.Video;

/**
 * 弥补简单工厂的不足，使用类提高扩展性
 */
public class Tests {

    public static void main(String[] args) {

        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(JavaVideo.class);
        video.produce();

    }

}
