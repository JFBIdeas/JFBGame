package jfb.domain.map;

import jfb.domain.dto.ObjectMap;

import java.util.HashMap;
import java.util.List;

public interface MapAction {

    Integer[][] loadMap (String pathFile);

    List<ObjectMap> getObjectMaps(Integer[][] interactiveMap);

    HashMap<Integer[][], ObjectMap> saveToMapAllObject(Integer[][] map, List<ObjectMap> listObjects);
}
