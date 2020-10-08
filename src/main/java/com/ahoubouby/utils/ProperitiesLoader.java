package com.ahoubouby.utils;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class ProperitiesLoader {
    
    public static Map<String, String > loadProps  ()  throws IOException  {
        Properties prop = new Properties();
        prop.load(new FileInputStream("myConfig.properties"));
        return null; 
    } 
}
