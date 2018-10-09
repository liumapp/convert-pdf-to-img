package com.liumapp.convert.img.service;

import com.liumapp.convert.img.PageConverter;
import com.liumapp.convert.img.config.ConverterParams;
import org.icepdf.core.pobjects.Document;
/**
 * file SinglePageConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/10/9
 */
public class SinglePageConverter extends ConverterParams implements PageConverter {

    private Integer pageNumber;

    public SinglePageConverter() {
    }

    @Override
    public boolean convert() throws Exception {
        Document document = new Document();
        document.setFile(this.sourcePdfPath);


        return false;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public SinglePageConverter setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }
}
