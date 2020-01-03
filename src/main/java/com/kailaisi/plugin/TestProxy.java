package com.kailaisi.plugin;

/**
 * 描述：
 * <p/>作者：wu
 * <br/>创建时间：2020/1/3 11:22
 */
class TestProxy {
    public static void main(String[] args) {
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
