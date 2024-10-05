package jfb.logsettings;

import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LogsConfigurationTest {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss, dd.MM.yyyy");
    private static final Path PATH_TO_DIRECTORY_LOG = Path.of("src/log");
    private static final Path PATH_TO_LOG_FILE = PATH_TO_DIRECTORY_LOG.resolve("log.txt");

    @BeforeAll
    static void startWriteLog() {
        LogsConfiguration.writeLog("Test");
    }

    @AfterAll
    static void deleteFile() {
        try {
            Files.delete(PATH_TO_LOG_FILE);
            Files.delete(PATH_TO_DIRECTORY_LOG);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    @Order(1)
    void getInstanceTest() {
        LogsConfiguration instance1 = LogsConfiguration.getInstance();
        LogsConfiguration instance2 = LogsConfiguration.getInstance();

        assertEquals(instance1, instance2);
    }

    @Test
    @Order(2)
    void checkFileTest() {
        assertTrue(Files.exists(PATH_TO_LOG_FILE));
        assertTrue(Files.exists(PATH_TO_DIRECTORY_LOG));
    }

    @Test
    @Order(3)
    void writeLogTest() {
        String expectedString = "1 - {%s} Test".formatted(TIME_FORMATTER.format(LocalDateTime.now()));

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_LOG_FILE.toString()))) {
            assertEquals(expectedString, bufferedReader.readLine());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    @Order(4)
    void writeExceptionStackTraceInLogFileTest() {
        IOException ioExceptionTest = new IOException();

        LogsConfiguration.writeExceptionStackTraceInLogFile(ioExceptionTest);

        String stackTrace = Arrays.stream(ioExceptionTest.getStackTrace())
                .map(StackTraceElement::toString)
                .collect(Collectors.joining("\n"));

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_TO_LOG_FILE.toFile()))) {
            bufferedReader.readLine();

            String expectedString = "2 - {%s} Возникло исключение - %s! StackTrace ошибок: \n%s"
                    .formatted(TIME_FORMATTER.format(LocalDateTime.now()), ioExceptionTest, stackTrace);
            String actualSting = bufferedReader.readLine() + " \n" + stackTrace;

            assertEquals(expectedString, actualSting);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    @Order(5)
    void deleteLogTest() {
        try {
            for (int i = Files.readAllLines(PATH_TO_LOG_FILE).size(); i < 15000; i++) {
                startWriteLog();
            }

            if (Files.readAllLines(PATH_TO_LOG_FILE).size() > 15000) {
                assertTrue(Files.lines(PATH_TO_LOG_FILE).findAny().isEmpty());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}