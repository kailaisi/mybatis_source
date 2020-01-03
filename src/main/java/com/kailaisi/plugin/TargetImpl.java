package com.kailaisi.plugin;

/**
 * 描述：
 * <p/>作者：wu
 * <br/>创建时间：2020/1/3 11:19
 */
public class TargetImpl implements Target {
    @Override
    public String execute(String name) {
        System.out.println("execute()"+name);
        return name;
    }
}
