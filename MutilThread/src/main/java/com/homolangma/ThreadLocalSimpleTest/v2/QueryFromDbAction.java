package com.homolangma.ThreadLocalSimpleTest.v2;

/**
 * @author: Mr.Harry
 * @date : 2020/5/21 23:00
 * @title :
 */
public class QueryFromDbAction {

    public void execute(Context context){
        try {
            Thread.sleep(1000);
            // 只能从DB 中拿名字
            String name="DB Tom"+Thread.currentThread().getName();
            context.setName(name);
        } catch (InterruptedException e) {
            System.out.println("execute E");

        }
    }



}
