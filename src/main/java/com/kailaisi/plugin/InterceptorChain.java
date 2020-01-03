package com.kailaisi.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述：拦截的链管理
 * <p/>作者：wu
 * <br/>创建时间：2020/1/3 14:32
 */
public class InterceptorChain {
    private List<Interceptor> interceptorList = new ArrayList<Interceptor>();

    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptorList) {
            target = interceptor.wrap(target);
        }
        return target;
    }

    public InterceptorChain addInterceptor(Interceptor interceptor) {
        interceptorList.add(interceptor);
        return this;
    }

    /**
     * 为了安全，此处返回一个不可修改的集合
     * @return
     */
    public List<Interceptor> getInterceptorList() {
        return Collections.unmodifiableList(interceptorList);
    }
}
