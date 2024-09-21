package jfb.logsettings;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LogsConfiguration {
    private static LogsConfiguration logging;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss, yyyy.MM.dd");
    private static final Path PATH_TO_DIRECTORY_LOG = Path.of("src/log");
    private static final Path PATH_TO_LOG_FILE = Path.of(PATH_TO_DIRECTORY_LOG + "/log.txt");
    private static int stringCount;

    public static LogsConfiguration getInstance() {
        synchronized (LogsConfiguration.class) {
            return logging == null ? new LogsConfiguration() : logging;
        }
    }

    public static void writeLog(String message) {
        checkFile();

        try (BufferedWriter fileWriter = Files.newBufferedWriter(PATH_TO_LOG_FILE, StandardOpenOption.APPEND)) {
            deleteLog();

            fileWriter.write(String.format("%d - {%s} %s\n", stringCount, TIME_FORMATTER.format(LocalDateTime.now()), message));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void deleteLog() {
        try {
            stringCount = Files.readAllLines(PATH_TO_LOG_FILE).size() + 1;

            if (stringCount > 15000) {
                stringCount = 1;

                Files.newBufferedWriter((PATH_TO_LOG_FILE), StandardOpenOption.TRUNCATE_EXISTING);
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

    public static void writeExceptionStackTraceInLogFile(StackTraceElement[] stackTraceElements) {
        writeLog("{" + TIME_FORMATTER.format(LocalDateTime.now()) + "} "
                    + Arrays.stream(stackTraceElements).map(StackTraceElement::toString).toList()
                    + "\n");

        writeLog(String.format("{%s} %s\n",
                TIME_FORMATTER.format(LocalDateTime.now()),
                Arrays.stream(stackTraceElements).map(StackTraceElement::toString).toList()));
    }
}
