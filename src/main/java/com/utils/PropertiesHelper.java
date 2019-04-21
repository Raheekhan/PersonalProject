package com.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

public class PropertiesHelper {

    String result = "";
    InputStream inputStream;

    public String getProperty(String property) {
        Properties prop = new Properties();
        String propertyFileName = "config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);

        try {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file '" + propertyFileName + "' was not found in the classpath.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        property = prop.getProperty(property);
        return property;
    }

//    public Set<String> getProperties() {
//        Properties prop = new Properties();
//        Set<String> properties = prop.stringPropertyNames();
//        String propertyFileName = "config.properties";
//        inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
//
//        try {
//            if (inputStream != null) {
//                prop.load(inputStream);
//            } else {
//                throw new FileNotFoundException("Property file '" + propertyFileName + "' was not found in the classpath.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        int i = 0;
//        for (String property : properties) {
//            System.out.println("Property Number: " + i++ + " | Property Name: " + property);
//        }
//
//        return properties;
//
//    }

}
