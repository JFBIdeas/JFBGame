package jfb;

import jfb.configLoader.ConfigLoader;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(ConfigLoader.loadConfig("application.properties"));

    }
}