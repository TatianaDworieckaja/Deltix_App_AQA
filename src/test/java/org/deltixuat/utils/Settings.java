package org.deltixuat.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class Settings {
    private static Properties properties;

    private Settings() {
    }

    public static Properties getPropertiess() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(new FileInputStream("src/test/resources/project.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return properties;
    }

    public static String getBaseUrl() {
        return getPropertiess().getProperty("baseURL");
    }

    public static String getBrowserType() {
        return getPropertiess().getProperty("browserType");
    }

    public static String getUserName() {
        return properties.getProperty("userName");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getDriverLocation() {
        return getPropertiess().getProperty("driverLocation");
    }

    public static URL getRemoteWebdriverUrl() {
        try {
            return new URL(properties.getProperty("remoteWebDriverUrl"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
