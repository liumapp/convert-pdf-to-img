package com.liumapp.convert.img;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author liumapp
 * @file SendOrderTest.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 5/7/18
 */
@RunWith(SpringRunner.class)
public class SendOrderTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void testKeepSend () {
        Thread sendThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        System.out.println("send a msg to queue");
                        amqpTemplate.convertAndSend("img-converter-queue" ,
                                "hello , now the time is : " + new Date());
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        sendThread.start();

        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
