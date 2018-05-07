package com.liumapp.convert.img.forward;

import com.liumapp.convert.img.concurrent.ThreadPools;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

/**
 * @author liumapp
 * @file QueueReceiver.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 5/7/18
 */
@Component
public class QueueReceiver implements InitializingBean {

    @Autowired
    private ThreadPools threadPools;

    private void receive () {
        ExecutorService processExecutor = threadPools.getMainPoolExecutor();
        while(true) {

        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Thread receiver = new Thread(new Runnable() {
            @Override
            public void run() {
                receive();
            }
        });

        receiver.setDaemon(true);
        receiver.start();
    }



}
