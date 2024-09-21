package jfb.configLoader;

import jfb.exception.NotFoundFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    public static ConfigProperties loadConfig(String fileName) {
        ConfigProperties configProperties = new ConfigProperties();
        Properties properties = new Properties();
        String rootPath ="src/main/resources/";
        String appConfigPath = rootPath + fileName;
        try {
            properties.load(new FileInputStream(appConfigPath));
            configProperties.setTest(properties.toString());
            return configProperties;
        } catch (IOException e) {
            throw new NotFoundFileException("Файл не найден!" + fileName);
        }
    }

}
