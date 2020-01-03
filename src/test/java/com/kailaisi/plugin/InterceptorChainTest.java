package com.kailaisi.plugin;

import org.junit.Test;

/**
 * 描述：
 * <p/>作者：wu
 * <br/>创建时间：2020/1/3 15:04
 */
public class InterceptorChainTest {
    @Test
    public void testChain() {
        Target target = new TargetImpl();
        InterceptorChain chain = new InterceptorChain();
        TimeIntercepter timeIntercepter = new TimeIntercepter();
        TransactionIntercepter transactionIntercepter = new TransactionIntercepter();
        chain.addInterceptor(timeIntercepter)
                .addInterceptor(timeIntercepter)
                .addInterceptor(transactionIntercepter)
                .addInterceptor(transactionIntercepter);
        Target proxyTarget = (Target) chain.pluginAll(target);
        proxyTarget.execute("kailaisi");
    }
}