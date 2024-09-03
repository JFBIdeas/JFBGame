package jfb.domain.gameobject.interfaces;

import java.awt.*;

/**
 * Основной интерфейс, прародитель всех объектов, которые могут существовать на карте
 */

public interface GameObject {
    // Позиционирование
    int getX();
    int getY();
    void setPosition(int x, int y);

    // Размеры
    int getWidth();
    int getHeight();
    void setSize(int width, int height);

    // Отрисовка
    void render(Graphics g);

}
