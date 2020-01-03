package com.kailaisi.plugin;

/**
 * 描述：
 * <p/>作者：wu
 * <br/>创建时间：2020/1/3 13:25
 */
class TransactionIntercepter implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Exception {
        System.out.println("开启事务........");
        Object result = invocation.process();
        System.out.println("提交事务........");
        return result;
    }

    @Override
    public Object wrap(Object target) {
        return TargetProxy.wrap(target,this);
    }
}
