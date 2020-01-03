package com.kailaisi.plugin;

/**
 * 描述：
 * <p/>作者：wu
 * <br/>创建时间：2020/1/3 11:56
 */
public class TimeIntercepter implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Exception {
        System.out.println("开始时间....");
        Object result = invocation.process();
        System.out.println("结束时间...");
        return result;
    }

    @Override
    public Object wrap(Object target) {
        return TargetProxy.wrap(target,this);
    }

}
