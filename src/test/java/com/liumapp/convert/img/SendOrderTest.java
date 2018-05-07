package com.liumapp.convert.img;

import junit.framework.TestCase;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author liumapp
 * @file SendOrderTest.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 5/7/18
 */
public class SendOrderTest extends TestCase {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void testKeepSend () {
        Thread sendThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        amqpTemplate.convertAndSend("img-converter-queue" ,
                                "hello , now the time is : " + new Date());
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        while (true) {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
