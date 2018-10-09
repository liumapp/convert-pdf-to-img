package com.liumapp.convert.img.service;

import com.liumapp.convert.img.PageConverter;
import com.liumapp.convert.img.config.ConverterParams;

import java.util.LinkedList;

/**
 * file AllPageConverter.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/10/9
 */
public class AllPageConverter extends ConverterParams implements PageConverter {

    private LinkedList<String> savenames;

    @Override
    public boolean convert() throws Exception {
        return false;
    }

    public LinkedList<String> getSavenames() {
        return savenames;
    }
}
