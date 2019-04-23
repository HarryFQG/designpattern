package com.homolangma.factory.simple.v1;

public class VideoFactory {

    public Video getVideo(String type){
        if("java".equalsIgnoreCase(type)){
            return new JavaVideo();
        }
        if("Python".equalsIgnoreCase(type)){
            return new PythonVideo();
        }
        return null;


    }



}
