package com.liumapp.convert.img.service;

import com.liumapp.convert.img.PageConverter;
import com.liumapp.convert.img.config.ConverterParams;
import com.liumapp.qtools.file.basic.FileTool;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.util.GraphicsRenderingHints;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import java.util.LinkedList;
import java.util.Random;

/**
 * file AllPageConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/10/9
 */
public class AllPageConverter extends ConverterParams implements PageConverter {

    private LinkedList<String> savenames = new LinkedList<String>();

    @Override
    public boolean convert() throws Exception {
        Document document = new Document();
        document.setFile(this.sourcePdfPath);
        BufferedImage image = null;
        //缩放比例
        float scale = 2.5f;
        //旋转角度
        float rotation = 0f;
        for (int i = 0; i < document.getNumberOfPages(); i++) {
            try {
                image = (BufferedImage)
                        document.getPageImage(i, GraphicsRenderingHints.SCREEN, org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation, scale);
                RenderedImage rendImage = image;
                ImageIO.write(rendImage, "png", FileTool.createFileObject(this.outputPath, this.generateRandomName()));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            image.flush();
        }
        document.dispose();
        System.gc();
        return true;
    }

    private String generateRandomName () {
        Random random = new Random();
        String tmpName = "";
        tmpName = System.currentTimeMillis() + "" + random.nextInt(1000) + ".png";
        this.savenames.add(tmpName);
        return tmpName;
    }

    public LinkedList<String> getSavenames() {
        return savenames;
    }
}
