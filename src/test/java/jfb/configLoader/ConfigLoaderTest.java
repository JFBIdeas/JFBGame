package jfb.configLoader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConfigLoaderTest {

    @Test
    void loadConfigPositiveTest() {
        //date
        String expected = "\"Checking the work with the file .properties\";";
        String keyName = "test";
        //test
        String actual = ConfigLoader.loadConfig(keyName);
        //check
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void loadConfigNegativeTest() {
        //date
        String keyName = " ";
        //test
        String actual = ConfigLoader.loadConfig(keyName);
        //check
        Assertions.assertNull(actual);
    }
}