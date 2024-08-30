package jfb.domain.map;

import jfb.domain.dto.ObjectMap;

import java.util.HashMap;
import java.util.List;

public abstract class Map {

    Integer[][] interactiveMap;

    HashMap<Integer[][], ObjectMap> interactiveObjectsMap;


    public Integer[][] getInteractiveMap() {
        return interactiveMap;
    }

    public void setInteractiveMap(Integer[][] interactiveMap) {
        this.interactiveMap = interactiveMap;
    }

    public HashMap<Integer[][], ObjectMap> getInteractiveObjectsMap() {
        return interactiveObjectsMap;
    }

    public void setInteractiveObjectsMap(HashMap<Integer[][], ObjectMap> interactiveObjectsMap) {
        this.interactiveObjectsMap = interactiveObjectsMap;
    }
}
