package com.liumapp.convert.img.service;

import com.liumapp.convert.img.PageConverter;
import com.liumapp.convert.img.config.ConverterParams;
import com.liumapp.qtools.file.basic.FileTool;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.util.GraphicsRenderingHints;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.util.Random;

/**
 * file SinglePageConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/10/9
 */
public class SinglePageConverter extends ConverterParams implements PageConverter {

    // 0 is the first page
    private Integer pageNumber;

    private String saveName;

    public SinglePageConverter() {
    }

    @Override
    public boolean convert() throws Exception {
        Document document = new Document();
        document.setFile(this.sourcePdfPath);
        BufferedImage image = null;
        //缩放比例
        float scale = 2.5f;
        //旋转角度
        float rotation = 0f;
        try {
            image = (BufferedImage)
                    document.getPageImage(this.pageNumber, GraphicsRenderingHints.SCREEN, org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation, scale);
            RenderedImage rendImage = image;
            ImageIO.write(rendImage, "png", FileTool.createFileObject(this.getOutputPath(), this.generateRandomSaveName()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        image.flush();
        System.gc();
        return true;
    }

    private String generateRandomSaveName () {
        Random random = new Random();
        this.saveName = System.currentTimeMillis() + "" + random.nextInt(1000) + ".png";
        return saveName;
    }

    public String getSaveName() {
        return saveName;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public SinglePageConverter setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }
}
