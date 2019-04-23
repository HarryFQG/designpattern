package com.homolangma.singleton.v2;



/**
 * @author 36732
 * @date 2019/4/14 10:34
 */
public class T implements Runnable {

    @Override
    public void run() {
        LazyDoubleCheckSingleton lazySingleton = LazyDoubleCheckSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+"--"+lazySingleton);

    }
}
