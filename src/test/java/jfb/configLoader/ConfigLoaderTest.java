package jfb.configLoader;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ConfigLoaderTest {
    /**
     * Тестируем метод по позитивному сценарию, который возвращает параметры по ключу
     *
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
        assertEquals(expected, actual);
    }

    /**
     * Тестируем метод по негативному сценарию, который возвращает параметры по ключу
     *
     * @see ConfigLoader#loadConfig(String)
     * Передаем в метод ключ " "(пустую строку), метод должен вернуть параметр null
     */
    @Test
    void loadConfigNegativeOneTest() {
        //date
        String keyName = " ";
        //test
        String actual = ConfigLoader.loadConfig(keyName);
        //check
        assertNull(actual);
    }
    /**
     * Тестируем метод по негативному сценарию на отсутствие файла
     *
     * @see ConfigLoader#loadConfig(String)
     * Проверяем наличие файла "application.properties",меняем название файла,
     * проверяем чтобы с таким названием файла не было в директории,
     * вызываем метод loadConfig(keyName) с ключом "test",
     * метод должен вернуть параметр null, т.к файл с именем "application.properties" отсутствует
     * возвращаем название файла "application.properties"
     */
    @Test
    void loadConfigNegativeTwoTest() {
        //date
        String keyName = "test";
        File oldFile = new File("src/main/resources/application.properties");
        boolean flag = true;
        File fileNew = null;
        if (oldFile.exists()) {
            while (flag) {
                String pathNew = "src/main/resources/application" + (int) (Math.random() * 10) + ".properties";
                fileNew = new File(pathNew);
                System.out.println(pathNew);
                if (!fileNew.exists()) {
                    oldFile.renameTo(fileNew);
                    flag = false;
                }
                System.out.println(pathNew);
            }
        }
        //test
        String actual = ConfigLoader.loadConfig(keyName);
        //check
        assertNull(actual);
        fileNew.renameTo(oldFile);
    }
}