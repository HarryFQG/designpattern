package com.homolangma.immutable;

import java.util.stream.IntStream;

/**
 * @author: Mr.Harry
 * @date : 2020/5/20 23:25
 * @title :
 */
public class ImmutableClient {

    public static void main(String[] args) {

        final Person person=new Person("Tom","USA");

        IntStream.range(0,5).forEach(i->{
            new UsePersonThread(person).start();
        });


    }

}
