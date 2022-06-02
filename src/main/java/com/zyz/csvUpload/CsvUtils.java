package com.zyz.csvUpload;

import au.com.bytecode.opencsv.CSVReader;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: YunzhenZhang
 * @Description:
 * @Date: Created in 17:50 2018/5/25
 */
public class CsvUtils {

    @Test
    public void upload() throws IOException {
        File file = new File("C:\\Users\\yunzhen.zhang\\Desktop\\test.csv");
        FileReader fileReader = new FileReader(file);
        CSVReader csvReader = new CSVReader(fileReader);
        String[] strings = csvReader.readNext();
        for(String string:strings){
            System.out.println(string);
        }

        List<String[]> strings1 = csvReader.readAll();

    }

    public void dowload(){

        List<String[]> strings = Lists.newArrayList();
        String[] a = {"a","b","c"};
        strings.add(a);


    }

}
