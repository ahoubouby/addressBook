package com.ahoubouby.configs;
/*
 * ahoubouby created on 10/8/20
 * E-MAIL: ahoubouby@gmail.com
 */

import com.ahoubouby.utils.CommandLineHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {

    public static final String FILE_NAME = "datasource.file.name";
    public static final String FILE_PATH = "datasource.file.path";
    private static Map<String, String> configs = null;
    private static final String LOADING_PROPS_EXP_MESSAGE = "exception rised while loading props with the next Message %1$s";

    public static Map<String, String> getConfigInstance() {
        if (configs == null) {
            loadProps();
        }
        return configs;
    }

    private static void loadProps() {
        try {
            Properties props = new Properties();
            configs = new HashMap<>();
            props.load(ClassLoader.getSystemResourceAsStream("application.properties"));
            configs.put(FILE_NAME, props.getProperty("datasource.file.name", "contacts.txt"));
            configs.put(FILE_PATH, props.getProperty("datasource.file.path", "."));
        } catch (IOException ex) {
            CommandLineHelper.showToUser(String.format(LOADING_PROPS_EXP_MESSAGE, ex.getMessage()));
            CommandLineHelper.exitProgram();
        }
    }
}
