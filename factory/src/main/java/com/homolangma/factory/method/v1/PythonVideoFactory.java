package com.homolangma.factory.method.v1;

/**
 * python工厂
 */
public class PythonVideoFactory extends VideoFactory {
    @Override
    Video getVideo() {
        return new PythonVideo();
    }
}
