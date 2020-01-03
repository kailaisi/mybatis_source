package com.kailaisi.mybatis.interceptor;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * 描述：
 * <p/>作者：wu
 * <br/>创建时间：2020/1/2 15:03
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
})
public class ExamplePlugin implements Interceptor {
    Logger logger = LoggerFactory.getLogger(ExamplePlugin.class);
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("ExamplePlugin开始处理");
        Object proceed = invocation.proceed();
        logger.info("ExamplePlugin处理完毕");
        return proceed;

    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
