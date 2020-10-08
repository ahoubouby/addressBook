package com.ahoubouby.utils;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ProperitiesLoader {

    public static final String FILE_NAME = "datasource.file.name"; 
    public static final String FILE_PATH = "datasource.file.path"; 
    
    public static Map<String, String> loadProps() throws IOException {
        Properties props = new Properties();
        Map<String, String> configs = new HashMap<>();
        props.load(ClassLoader.getSystemResourceAsStream("application.properties"));
        configs.put(FILE_NAME, props.getProperty("datasource.file.name"));
        configs.put(FILE_PATH, props.getProperty("datasource.file.path"));
        return configs;
    }
}
