package jfb.logsettings;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LogsConfiguration {
    private static LogsConfiguration logging;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss, dd.MM.yyyy");
    private static final Path PATH_TO_DIRECTORY_LOG = Path.of("src/log");
    private static final Path PATH_TO_LOG_FILE = PATH_TO_DIRECTORY_LOG.resolve("log.txt");
    private static int stringCount;

    public static LogsConfiguration getInstance() {
        synchronized (LogsConfiguration.class) {
            if (logging == null) {
                logging = new LogsConfiguration();
            }
            return logging;
        }
    }

    public static void writeLog(String message) {
        checkFile();

        try (BufferedWriter fileWriter = Files.newBufferedWriter(PATH_TO_LOG_FILE, StandardOpenOption.APPEND)) {
            deleteLog();
            fileWriter.write("%d - {%s} %s\n".formatted(stringCount, TIME_FORMATTER.format(LocalDateTime.now()), message));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void deleteLog() {
        try {
            stringCount = Files.readAllLines(PATH_TO_LOG_FILE).size() + 1;

            if (stringCount > 15000) {
                stringCount = 1;
                Files.newBufferedWriter(PATH_TO_LOG_FILE, StandardOpenOption.TRUNCATE_EXISTING).close();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void checkFile() {
        try {
            if (!Files.exists(PATH_TO_DIRECTORY_LOG)) {
                Files.createDirectories(PATH_TO_DIRECTORY_LOG);
            }

            if (!Files.exists(PATH_TO_LOG_FILE)) {
                Files.createFile(PATH_TO_LOG_FILE);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void writeExceptionStackTraceInLogFile(Exception e) {
        String stackTrace = Arrays.stream(e.getStackTrace())
                .map(StackTraceElement::toString)
                .collect(Collectors.joining("\n"));

        writeLog("Возникло исключение - %s! StackTrace ошибок:\n%s".formatted(e, stackTrace));
    }
}
