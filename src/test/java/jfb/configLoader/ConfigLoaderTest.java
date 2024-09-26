package jfb.configLoader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConfigLoaderTest {
    /**
     *Тестируем метод по позитивному сценарию, который возвращает параметры по ключу
     * @see ConfigLoader#loadConfig(String)
     * Передаем в метод ключ "test", метод должен вернуть параметр совпадающий со
     * сравниваемой строкой "\"Checking the work with the file .properties\"
     */
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
    /**
     *Тестируем метод по негативному сценарию, который возвращает параметры по ключу
     * @see ConfigLoader#loadConfig(String)
     * Передаем в метод ключ " "(пустую строку), метод должен вернуть параметр null
     */
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