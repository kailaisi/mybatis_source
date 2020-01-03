package com.kailaisi.plugin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述：
 * <p/>作者：wu
 * <br/>创建时间：2020/1/3 11:20
 */
class TargetProxy implements InvocationHandler {
    private Object target;
    private Interceptor interceptor;
    TargetProxy(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(target,method,args);
        Object result =interceptor.intercept(invocation);
        return result;
    }

    //静态方法，用于生成代理类
    public static Object wrap(Object target,Interceptor interceptor){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new TargetProxy(target, interceptor));
    }
}
