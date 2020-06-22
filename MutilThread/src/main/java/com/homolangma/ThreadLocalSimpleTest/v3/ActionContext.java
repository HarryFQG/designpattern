package com.homolangma.ThreadLocalSimpleTest.v3;

/**
 * @author: Mr.Harry
 * @date : 2020/5/24 10:40
 * @title :
 */
public class ActionContext {

    private static final ThreadLocal<Context> threadLocal = new ThreadLocal<Context>() {
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    private static class ContextHolder {
        private final static ActionContext actionContext = new ActionContext();
    }

    public static ActionContext getInstance() {
        return ContextHolder.actionContext;
    }


    public Context getContext() {


        return threadLocal.get();
    }

}
