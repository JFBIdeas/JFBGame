package jfb.logsettings;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LogsConfiguration {
    private static LogsConfiguration logging;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss, yyyy.MM.dd");
    private static final Path PATH_TO_LOG_FILE = Path.of("/srs/log/");
    private static final Path PATH_TO_DIRECTORY_LOG = Path.of("/srs/log");

    public static LogsConfiguration getInstance() {
        synchronized (LogsConfiguration.class) {
            return logging == null ? new LogsConfiguration() : logging;
        }
    }

    public static void writeLog(String message) {
        File file = Files.exists(PATH_TO_LOG_FILE) ? PATH_TO_LOG_FILE.toFile() : new File(PATH_TO_LOG_FILE.toString());

        try (BufferedWriter fileWriter = Files.newBufferedWriter(LOG_FILE.toPath(), StandardOpenOption.APPEND)) {

            int stringCount = Files.readAllLines(LOG_FILE.toPath()).size() + 1;

            if (stringCount > 15000) { deleteLog(); }

            fileWriter.write(stringCount + " - " + "{" + TIME_FORMATTER.format(LocalDateTime.now()) + "} " + message + "\n");

        } catch (Exception e) { e.printStackTrace(); }
    }

    private static void deleteLog() {
        try {
            Files.newBufferedWriter(LOG_FILE.toPath(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void writeExceptionStackTraceInLogFile(StackTraceElement[] stackTraceElements) {
        writeLog("{" + TIME_FORMATTER.format(LocalDateTime.now()) + "} "
                    + Arrays.stream(stackTraceElements).map(StackTraceElement::toString).toList()
                    + "\n");
    }
}
