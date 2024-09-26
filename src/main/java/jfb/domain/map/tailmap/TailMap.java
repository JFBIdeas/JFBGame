package jfb.domain.map.tailmap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TailMap {

    public int[][] loadMap(String fileName) {
        List<List<Integer>> listTailMap = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
            listTailMap = reader.lines()
                    .map(line -> Stream.of(line.split(","))
                            .map(String::trim)
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + fileName, e);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Файл содержит неверные данные.", e);
        }

        return convertListToPrimitiveArray(listTailMap);
    }

    private int[][] convertListToPrimitiveArray(List<List<Integer>> list) {
        if (list.isEmpty()) return new int[0][0];

        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> row = list.get(i);
            array[i] = row.stream().mapToInt(Integer::intValue).toArray();
        }
        return array;
    }
}
