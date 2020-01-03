package com.kailaisi.plugin;

/**
 * 描述：
 * <p/>作者：wu
 * <br/>创建时间：2020/1/3 11:50
 */
interface Interceptor {
    /**
     * 具体拦截处理
     * @param invocation
     * @return
     * @throws Exception
     */
    Object intercept(Invocation invocation) throws Exception;

    /**
     * 要代理的类
     * @param target
     * @return
     */
    Object wrap(Object target);
}
