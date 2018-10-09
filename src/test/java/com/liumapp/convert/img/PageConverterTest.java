package com.liumapp.convert.img;

import com.liumapp.convert.img.service.SinglePageConverter;
import org.junit.Test;

/**
 * file PageConverterTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/10/9
 */
public class PageConverterTest {



    private String sourcePdfPath = "/usr/local/tomcat/project/convert-pdf-to-img/pdf/test.pdf";

    private String outputPath = "/usr/local/tomcat/project/convert-pdf-to-img/img/";

    @Test
    public void convertSinglePage () {
        SinglePageConverter singlePageConverter = new SinglePageConverter();
        singlePageConverter.setSourcePdfPath(sourcePdfPath);
        singlePageConverter.setOutputPath(outputPath);
    }

    @Test
    public void convertAllPage () {

    }

}
