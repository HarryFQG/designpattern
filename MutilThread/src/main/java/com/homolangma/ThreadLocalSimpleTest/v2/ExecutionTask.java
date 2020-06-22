package com.homolangma.ThreadLocalSimpleTest.v2;

/**
 * @author: Mr.Harry
 * @date : 2020/5/21 23:00
 * @title :
 */
public class ExecutionTask implements Runnable {
    private QueryFromDbAction queryFromDbAction = new QueryFromDbAction();

    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();
    @Override
    public void run() {
        final Context context = new Context();
        queryFromDbAction.execute(context);
        System.out.println("此时结果1："+context.toString());

        queryFromHttpAction.execute(context);
        System.out.println("此时结果2："+context.toString());
    }
}
