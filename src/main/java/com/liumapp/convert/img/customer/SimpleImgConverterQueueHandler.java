package com.liumapp.convert.img.customer;

import com.alibaba.fastjson.JSON;
import com.liumapp.convert.img.pattern.SimplePdfPattern;
import com.liumapp.convert.img.service.SinglePageConvertService;
import com.liumapp.convert.img.threadpools.ThreadPools;
import org.icepdf.core.pobjects.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liumapp
 * @file SimpleImgConverterQueueHandler.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 5/7/18
 */
@Component
@RabbitListener(queues = "simple-img-converter-queue")
public class SimpleImgConverterQueueHandler {

    private static Logger logger = LoggerFactory.getLogger(SimpleImgConverterQueueHandler.class);

    @Autowired
    private SinglePageConvertService singlePageConvertService;

    @Autowired
    private ThreadPools threadPools;

    @RabbitHandler
    public void process (String msg) {
        logger.info("get msg from simple-img-converter-queue , the msg is : \n " + msg + "\n");
        SimplePdfPattern simplePdfPattern = JSON.parseObject(msg, SimplePdfPattern.class);
        Document document = new Document();

        try {
            document.setFile(simplePdfPattern.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        singlePageConvert(document);
        multyPageConvert(document);
    }

    private void singlePageConvert (Document document) {
        ThreadPoolExecutor threadPoolExecutor = threadPools.getThreadPoolExecutor();
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                singlePageConvertService.convertFirstPage(document);
            }
        });
    }

    private void multyPageConvert (Document document) {
        ThreadPoolExecutor threadPoolExecutor = threadPools.getThreadPoolExecutor();
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}
