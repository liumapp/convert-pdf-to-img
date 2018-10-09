# convert-pdf-to-img

## how to use

use maven to import :
    
    <dependency>
        <groupId>com.liumapp.convert.img</groupId>
        <artifactId>convert-pdf-to-img</artifactId>
        <version>v1.1.0</version>
    </dependency>
    
code like junit case :


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