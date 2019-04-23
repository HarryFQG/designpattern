package com.homolangma.factory.method.v1;

/**
 * 工厂的实现
 */
public class JavaVideoFactory extends VideoFactory{
    @Override
    Video getVideo() {
        return new JavaVideo();
    }
}
