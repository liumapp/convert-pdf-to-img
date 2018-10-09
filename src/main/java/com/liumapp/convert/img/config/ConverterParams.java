package com.liumapp.convert.img.config;

/**
 * file ConverterParams.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/10/9
 */
public class ConverterParams {

    public String outputPath;

    public String sourcePdfPath;

    public ConverterParams() {
    }

    public String getOutputPath() {
        return outputPath;
    }

    public ConverterParams setOutputPath(String outputPath) {
        this.outputPath = outputPath;
        return this;
    }

    public String getSourcePdfPath() {
        return sourcePdfPath;
    }

    public ConverterParams setSourcePdfPath(String sourcePdfPath) {
        this.sourcePdfPath = sourcePdfPath;
        return this;
    }
}
