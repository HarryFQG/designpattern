package com.homolangma.ThreadLocalSimpleTest.v3;

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
        final Context context = ActionContext.getInstance().getContext();
        queryFromDbAction.execute();
        System.out.println("此时结果1："+context.toString());
        queryFromHttpAction.execute();
        System.out.println("此时结果2："+context.toString());
    }
}
