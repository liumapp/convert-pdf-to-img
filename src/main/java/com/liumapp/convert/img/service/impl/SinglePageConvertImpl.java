package com.liumapp.convert.img.service.impl;

import com.liumapp.convert.img.pattern.ImgPattern;
import com.liumapp.convert.img.service.SinglePageConvertService;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.util.GraphicsRenderingHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author liumapp
 * @file SinglePageConvertImpl.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 5/7/18
 */
@Service
public class SinglePageConvertImpl implements SinglePageConvertService {

    @Autowired
    private ImgPattern imgPattern;

    @Override
    public void convertFirstPage(Document document) {
        BufferedImage image = null;
        float scale = 2.5f;//缩放比例
        float rotation = 0f;//旋转角度
        try {
            image = (BufferedImage)
                    document.getPageImage(0, GraphicsRenderingHints.SCREEN, org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation, scale);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RenderedImage rendImage = image;
        try {
            //随机数
            Random random = new Random();
            String fileName = "pdfConverter" + System.currentTimeMillis() + "" + random.nextInt(1000)+".jpg";
            File file = new File(imgPattern.getPath() + fileName);
            ImageIO.write(rendImage, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        image.flush();
        document.dispose();
        System.gc();
    }

}
