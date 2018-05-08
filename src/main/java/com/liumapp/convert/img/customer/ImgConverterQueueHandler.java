package com.liumapp.convert.img.customer;

import com.alibaba.fastjson.JSON;
import com.liumapp.convert.img.pattern.PdfPattern;
import com.liumapp.convert.img.service.SinglePageConvertService;
import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author liumapp
 * @file ImgConverterQueueHandler.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 5/7/18
 */
@Component
@RabbitListener(queues = "img-converter-queue")
public class ImgConverterQueueHandler {

    private static Logger logger = LoggerFactory.getLogger(ImgConverterQueueHandler.class);

    @Autowired
    private SinglePageConvertService singlePageConvertService;



    @RabbitHandler
    public void process (String msg) {
        logger.info("get msg from img-converter-queue , the msg is : \n " + msg + "\n");
        PdfPattern pdfPattern = JSON.parseObject(msg, PdfPattern.class);
        Document document = new Document();

        try {
            document.setFile(pdfPattern.getPath());
        } catch (PDFException e) {
            e.printStackTrace();
        } catch (PDFSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        singlePageConvertService.convertFirstPage(document);
    }

}
