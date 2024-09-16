package jfb.domain.gameobject.abstractclasses;

import jfb.domain.gameobject.interfaces.GameObject;

import java.awt.*;

public abstract class AbstractGameObject implements GameObject {

    //координаты x, y;
    private int x, y;
    //параметры ширина и высота
    private int width, height;

    public AbstractGameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setPosition(int x, int y) {
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setSize(int width, int height) {
    }

    @Override
    public void render(Graphics g) {
    }
}
