package com.homolangma.factory.abstractFactory;

/**
 * 抽象工厂
 * 抽象类、接口
 */
public interface CourseFactory {

    /**
     * 视频
     * @return
     */
    Video getVideo();

    /**
     * 笔记
     * @return
     */
    Article getArticle();


}
