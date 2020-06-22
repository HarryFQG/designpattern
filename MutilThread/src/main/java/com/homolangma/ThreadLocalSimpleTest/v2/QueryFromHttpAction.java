package com.homolangma.ThreadLocalSimpleTest.v2;

/**
 * @author: Mr.Harry
 * @date : 2020/5/21 23:05
 * @title :
 */
public class QueryFromHttpAction {

    public void execute(Context context){
        try {
            Thread.sleep(1000);
            // 只能从公安中 中拿身份证号
            String id="http CardID"+Thread.currentThread().getName();
            context.setCardId(id);
        } catch (InterruptedException e) {
            System.out.println("execute E");

        }
    }

}
