package com.liumapp.convert.img.concurrent;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liumapp
 * @file ThreadPools.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 5/7/18
 */
@Component
public class ThreadPools implements InitializingBean {

    private ThreadPoolExecutor mainPoolExecutor;

    @Override
    public void afterPropertiesSet() throws Exception {
        mainPoolExecutor = new ThreadPoolExecutor(10,
                200,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>());
    }

}
