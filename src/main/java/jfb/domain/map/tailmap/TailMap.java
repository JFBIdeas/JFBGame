package jfb.domain.map.tailmap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TailMap{
    //двумерный массив, что принимает в аргумент путь до файла, что нужно распарсить
    Integer[][] loadMap(String fileName) {
        List<List<Integer>> listTailMap = new ArrayList<>();
        //коллекция ЭррэйЛист, что хранит в себе значение другой коллекции с дженериком Интеджер

        try (BufferedReader bufRead = new BufferedReader(new FileReader(fileName))) {
            //блок try, в качестве аргумента принимает в себя буффер, читающий файл по переменной
            String line;
            //через цикл с условием, что в буффере есть данные для чтения
            while ((line = bufRead.readLine()) != null) {

                //Бьем строку по запятым
                String[] separator = line.split(",");
                List<Integer> listTail = new ArrayList<>();
                //через цикл строка парсится по разделителю
                for (String value : separator) {
                    listTail.add(Integer.parseInt(value.trim()));
                }
                listTailMap.add(listTail);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertListToArray(listTailMap);
    }

    private Integer[][] convertListToArray(List<List<Integer>> list) {
        if (list.isEmpty()) return new Integer[0][0];

        Integer[][] array = new Integer[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i).toArray(new Integer[0]);
        }
        return array;
    }
}


/*      public static void main(String[] args) {
        TailMap load = new TailMap();
        //тут путь до файла указываем, читает .txt, с rtf какие то проблемы
        Integer[][] map = load.loadMap("/Users/RGZ_TTT/Downloads/LOADMAP.rtf");
        //вывод
        for (Integer[] row : map) {
            for (Integer value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
*/