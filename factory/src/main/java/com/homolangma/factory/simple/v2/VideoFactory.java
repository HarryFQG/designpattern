package com.homolangma.factory.simple.v2;

import com.homolangma.factory.simple.v1.Video;

public class VideoFactory {

    public Video getVideo(Class  clazz){
        Video video=null;
        try {
            video= (Video) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }

}
