package com.liumapp.convert.img;

import com.liumapp.convert.img.service.AllPageConverter;
import com.liumapp.convert.img.service.SinglePageConverter;
import com.liumapp.qtools.file.basic.FileTool;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * file PageConverterTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/10/9
 */
public class PageConverterTest {

    private String dataPath = "/usr/local/tomcat/project/convert-pdf-to-img/data/";

    @Test
    public void convertSinglePage () throws Exception {
        SinglePageConverter singlePageConverter = new SinglePageConverter();
        singlePageConverter.setSourcePdfPath(dataPath + "/pdf/test.pdf");
        singlePageConverter.setOutputPath(dataPath + "/pic/first/");
        singlePageConverter.setPageNumber(0);// 0 is the first page
        boolean result = singlePageConverter.convert();
        Assert.assertEquals(true, result);
        System.out.println("savename is : " + singlePageConverter.getSaveName());
        Assert.assertEquals(true, FileTool.isFileExists(dataPath + "/pic/first/" + singlePageConverter.getSaveName()));
    }

    @Test
    public void convertAllPage () throws Exception {
        AllPageConverter allPageConverter = new AllPageConverter();
        allPageConverter.setSourcePdfPath(dataPath + "/pdf/test.pdf");
        allPageConverter.setOutputPath(dataPath + "/pic/all/");
        boolean result = allPageConverter.convert();
        Assert.assertEquals(true, result);
        LinkedList<String> names = allPageConverter.getSavenames();
        System.out.println("savename is : ");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
            Assert.assertEquals(true, FileTool.isFileExists(dataPath + "/pic/all/" + names.get(i)));
        }
    }

}
