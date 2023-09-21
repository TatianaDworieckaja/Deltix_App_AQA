package org.deltixuat.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebProperties { //read properties from a file and pass them

    private static Properties properties;

    public static Properties getPropertiess(){
        if(properties==null){
            properties = new Properties();
            try{
                properties.load(new FileInputStream("src/test/resources/project.properties"));
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        }
        return properties;
    }

    public static String getBaseUrl(){
        return getPropertiess().getProperty("baseURL");
    }

    public static String getBrowserType(){
        return getPropertiess().getProperty("browserType");
    }

    public static String getDriverLocation(){
        return getPropertiess().getProperty("driverLocation");

    }

}
