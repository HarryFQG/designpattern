package com.homolangma.factory.abstractFactory;

public class PythonArticle extends Article{
    @Override
    public void produce() {
        System.out.println("编写Python 手记");
    }
}
