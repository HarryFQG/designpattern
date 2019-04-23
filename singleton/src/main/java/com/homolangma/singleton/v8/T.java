package com.homolangma.singleton.v8;

/**
 * @author 36732
 * @date 2019/4/14 17:24
 */
public class T implements Runnable {
    @Override
    public void run() {
        ContainerSingleton.putInstance("object", new Object());
        ContainerSingleton.getInstance("object");
        System.out.println(Thread.currentThread().getName() + "----" + ContainerSingleton.getInstance("object"));

    }
}
