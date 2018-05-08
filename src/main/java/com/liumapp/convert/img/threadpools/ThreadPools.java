package com.liumapp.convert.img.threadpools;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liumapp
 * @file ThreadPools.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 5/8/18
 */
@Component
public class ThreadPools implements InitializingBean {

    private ThreadPoolExecutor threadPoolExecutor;

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        
    }

}
