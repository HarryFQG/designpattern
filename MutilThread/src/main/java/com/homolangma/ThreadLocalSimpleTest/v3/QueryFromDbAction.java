package com.homolangma.ThreadLocalSimpleTest.v3;

/**
 * @author: Mr.Harry
 * @date : 2020/5/21 23:00
 * @title :
 */
public class QueryFromDbAction {

    public void execute(){
        try {
            Thread.sleep(1000);
            // 只能从DB 中拿名字
            String name="DB Tom"+Thread.currentThread().getName();
            ActionContext.getInstance().getContext().setName(name);
        } catch (InterruptedException e) {
            System.out.println("execute E");

        }
    }



}
